package com.edu118.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.edu118.po.Type;
import com.edu118.po.User;
import com.edu118.type.TypeService;
import com.edu118.vo.DataResult;

@RestController
public class TypeAction {
	@Resource
	private TypeService typeService;
	
	@RequestMapping("getAllType")
	public DataResult<List<Type>> getAllType() {
		DataResult<List<Type>> dataResult = new DataResult<>();
		dataResult.setData(typeService.selectAll());
		return dataResult;
	}
	
	@RequestMapping("addType")
	public DataResult<Type> addType(
			@Validated Type type,BindingResult bResult,
			@SessionAttribute("currUser") User currUser) {
		
		System.out.println(type);
		
		DataResult<Type> dataResult = new DataResult<>();
		if(bResult.hasErrors()) {
			dataResult.setMessage(bResult.getAllErrors().get(0).getDefaultMessage());
			
		}else {
			//判断当前用户的权限，管理员、主管、仓库管理员都可以进行供应商的数据添加
			if (currUser.getLevel().matches("[012]")) {
				if(typeService.insertType(type)) {
					dataResult.setMessage("物料类型信息添加完成！");
					dataResult.setState(true);
					
				}else{
					dataResult.setMessage("物料类型信息添加失败！");
				}
				
			}else {
				dataResult.setMessage("您没有此操作权限！");
			}
		}
		return dataResult ;
	}
}
