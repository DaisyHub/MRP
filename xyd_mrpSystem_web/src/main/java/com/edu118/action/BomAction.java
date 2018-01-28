package com.edu118.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.edu118.bom.BomService;
import com.edu118.po.Bom;
import com.edu118.po.CustomBomBean;
import com.edu118.po.Parts;
import com.edu118.vo.DataResult;


@RestController
public class BomAction {

	@Resource
	public BomService bomService;
	
	@RequestMapping("addBom")
	public DataResult<Bom> addBom(@RequestParam Map<String, Object> map){
		DataResult<Bom> dataResult = new DataResult<>();
		//将拼接出来的数据转换成List存放到map中
		List<Parts> bomList = JSON.parseArray(map.get("datas")+"", Parts.class);
		map.put("bomList",bomList);
		//这里的权限就不做验
		if(bomService.insertBom(map) != bomList.size()) {
			dataResult.setMessage("数据保存失败，请检查数据！");
		}else {
			dataResult.setMessage("数据保存完成！");
			dataResult.setState(true);
		}
		System.out.println(dataResult);
		return dataResult;
	}
	
	@RequestMapping("getBomData")
	public DataResult<List<CustomBomBean>> getBomData(Integer productId) {
//		System.out.println("***"+productId);
		DataResult<List<CustomBomBean>> dataResult = new DataResult<>();
		dataResult.setData(bomService.findBomByProductId(productId));
		return dataResult;
	}
}
