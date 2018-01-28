package com.edu118.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu118.po.CustomProduct;
import com.edu118.po.ProductName;
import com.edu118.product.ProductService;
import com.edu118.validation.ValueRuleValidator;
import com.edu118.vo.DataResult;

@RestController
public class ProductAction {
	@Resource
	private ProductService productService;
	
	@RequestMapping("addProductName")
	public DataResult<ProductName> addProductName(ProductName productName) {
		DataResult<ProductName> dataResult = new DataResult<>();
		if (productName == null || !ValueRuleValidator.isString(productName.getPname())) {
			dataResult.setMessage("请输入产品名称！");
			
		}else {
			if(productService.insertProductNameMapper(productName)){
				dataResult.setMessage("产品名称数据添加完成！");
				dataResult.setState(true);
			}else {
				dataResult.setMessage("产品名称数据添加失败！");
			}
		}
		return dataResult ;
	}
	
	@RequestMapping("getAllProduct")
	public DataResult<List<CustomProduct>> getAllProduct(){
		DataResult<List<CustomProduct>> dataResult = new DataResult<>();
		dataResult.setData(productService.selectProduct());
//		System.out.println(productService.selectProduct());
		return dataResult;
	}
}
