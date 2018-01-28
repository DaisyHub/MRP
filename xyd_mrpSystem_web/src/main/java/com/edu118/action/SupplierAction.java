package com.edu118.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.edu118.po.Supplier;
import com.edu118.po.User;
import com.edu118.supplier.SupplierService;
import com.edu118.vo.DataResult;

//@Controller
//@ResponseBody
@RestController	//=@Controller + @ResponseBody
public class SupplierAction {
	@Resource
	private SupplierService supplierService;
	
	@RequestMapping("getAllSupplier")
	public DataResult<List<Supplier>> getAllSupplier() {
		DataResult<List<Supplier>> dataResult = new DataResult<>();
		dataResult.setData(supplierService.selectAll());
		return dataResult;
	}
	
	@RequestMapping("addSupplier")
	public DataResult<Supplier> addSupplier( 
			@Validated Supplier supplier,BindingResult bResult,
			@SessionAttribute("currUser") User currUser ) {
		
		DataResult<Supplier> dataResult = new DataResult<>();
		
		if(bResult.hasErrors()) {
			dataResult.setMessage(bResult.getAllErrors().get(0).getDefaultMessage());
			
		}else {
			//判断当前用户的权限，管理员、主管、仓库管理员都可以进行供应商的数据添加
			if (currUser.getLevel().matches("[012]")) {
				if(supplierService.insertSupplier(supplier)) {
					dataResult.setMessage("供应商信息添加完成！");
					dataResult.setState(true);
					
				}else{
					dataResult.setMessage("供应商信息添加失败！");
				}
				
			}else {
				dataResult.setMessage("您没有此操作权限！");
			}
		}
		return dataResult;
	}
}
