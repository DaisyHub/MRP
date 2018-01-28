package com.edu118.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.alibaba.fastjson.JSON;
import com.edu118.pagingbean.MyPagin;
import com.edu118.po.Parts;
import com.edu118.po.User;
import com.edu118.repository.PartsService;
import com.edu118.validation.ValueRuleValidator;
import com.edu118.vo.DataResult;

@RestController
public class PartsAction {
	@Resource 
	private PartsService partsService;
	
	
	/**
	 * 
	 * 物料出入库查询
	 * @return
	 */
	@RequestMapping("queryLikeParts")
	public MyPagin queryLikeParts(@RequestParam Map<String, Object> map){
		
		DataResult<List<Parts>> dataResult = new DataResult<>();
		MyPagin myPagin = new MyPagin();
		myPagin.setCurrPage(Integer.parseInt(map.get("currPage")+""));
		myPagin.setPageSize(Integer.parseInt(map.get("pageSize")+""));
		System.out.println((map.get("flag")+"--"+map.get("startDate")));
		
		if(!(map.get("flag") + "").matches("[012]")) {
			dataResult.setMessage("请选择查询是出库，入库还是全部");
		}else if(!ValueRuleValidator.isDate(map.get("startDate") + "")){
			dataResult.setMessage("请选择查询的开始日期");
		}else if(!ValueRuleValidator.isDate(map.get("endDate") + "")) {
			dataResult.setMessage("请选择查询的截至日期");
		}else {
			//开始查询
			myPagin.setTotalRecords(partsService.queryLikePartsCount(map, myPagin));
			List<Parts> parts = partsService.queryLikeParts(map, myPagin);
			myPagin.setData(parts);
			System.out.println("**"+parts);
			
		}
		return myPagin;
	}
	
	
	@RequestMapping("addParts")
	public DataResult<Parts> addParts(@Validated Parts parts,BindingResult bResult,
			@SessionAttribute("currUser") User currUser ) {
		DataResult<Parts> dataResult = new DataResult<>();
		System.out.println("parts:"+parts);
		if (bResult.hasErrors()) {
			String errors = "";
			for(ObjectError oe : bResult.getAllErrors()) {
				errors += oe.getDefaultMessage() + "<br/>";
			}
			dataResult.setMessage(errors);
		}else {
			//做权限的验证
			//判断当前用户的权限，管理员、主管、仓库管理员都可以进行供应商的数据添加
			if (currUser.getLevel().matches("[012]")) {
				if(partsService.insertParts(parts)) {
					dataResult.setMessage("配件信息添加完成！");
					dataResult.setState(true);
					
				}else{
					dataResult.setMessage("配件信息添加失败！");
				}
				
			}else {
				dataResult.setMessage("您没有此操作权限！");
			}
		}
		
		return dataResult ;
	}
	
	@RequestMapping("getAllParts")
	public DataResult<List<Parts>> getAllParts(){
		DataResult<List<Parts>> dataResult = new DataResult<>();
		dataResult.setData(partsService.selectAllParts());
		return dataResult;
	}
	
	/**
	 * 批量添加配件数据
	 */
	@RequestMapping("addManyParts")
	public DataResult<Parts> addManyParts(
			@RequestParam Map<String, Object> map,
			@SessionAttribute("currUser") User currUser) {
		DataResult<Parts> dataResult = new DataResult<>();
		
		System.out.println(map);
		
		//权限
		if (currUser.getLevel().matches("[012]")) {
			
			//单号
			if (!(map.get("partsDanhao")+"").matches("XYD-CK-[\\d]{14}-[\\d]{5}")) {
				dataResult.setMessage("请按格式输入配件入库单号，格式为：XYD-CK-20180105141127-63885");
				
			//日期
			}else if(!(map.get("date")+"").matches("((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]")) {
				dataResult.setMessage("请按格式输入日期：2018-01-05 14:11:27");
				
				
			}else if (!"2".equals(map.get("flag"))) {
				dataResult.setMessage("请设置出库的标志：flag=2");
				
			}else {
				//把JSON数据转换成Parts对象
				List<Parts> parseArray = JSON.parseArray(map.get("datas")+"", Parts.class);
				if (parseArray.size() <= 0) {
					dataResult.setMessage("请填写出库的配件数据！");
					
				}else {
					//遍历配件的数据
					Parts p = null;
					for (int i =0;i < parseArray.size();i++) {
						//配件名称、单位、出库的数量
						p = parseArray.get(i);
						if (!ValueRuleValidator.isString(p.getPartsName())) {
							dataResult.setMessage("请填写第【" + (i+1) + "】行的出库配件名称！");
							return dataResult ;
							
						}else if (!ValueRuleValidator.isString(p.getUnit())) {
							dataResult.setMessage("请填写第【" + (i+1) + "】行的配件单位！");
							return dataResult ;
							
						}else if (!ValueRuleValidator.isInt(p.getCount()+"")) {
							dataResult.setMessage("请填写第【" + (i+1) + "】行的配件出库数量！");
							return dataResult ;
							
						}else {
							//出库的数量是否大余结存 
							map.put("surplusCount", "yes");	//得知道库存的余量 = sum(入库count) - sum(出库count)
							map.put("partsName", p.getPartsName());
							
							//直接查询库存余量，如果返回null，说明没有出库数量
							Integer surplusCount = 0;	//记录库存余量
							surplusCount = partsService.getPartsSurplusCount(map);
							if(surplusCount == null) {
								//查询入库数量
								map.put("surplusCount", null);
								surplusCount = partsService.getPartsSurplusCount(map);
								if(surplusCount == null) {
									dataResult.setMessage("第【" + (i+1) + "】行的配件没有可用数据！");
									return dataResult ;
								}
							}
							
							//判断出库数量是否在库存余量中
							if (surplusCount < p.getCount()) {
								dataResult.setMessage("第【" + (i+1) + "】行的配件库存不足，库存量：【" + surplusCount + "】！");
								return dataResult ;
							}
							
						}
					}
					
					map.put("partsList",parseArray);
					if(partsService.insertManyParts(map) == parseArray.size()) {
						dataResult.setMessage("数据保存完成！");
						dataResult.setState(true);
					}else {
						dataResult.setMessage("数据保存失败！！");
					}
				}
			}
			
		}else {
			dataResult.setMessage("您没有此操作权限！");
		}
		
		return dataResult ;
	}
}
