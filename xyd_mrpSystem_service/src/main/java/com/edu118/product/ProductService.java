package com.edu118.product;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu118.mapper.ProductMapper;
import com.edu118.mapper.ProductNameMapper;
import com.edu118.mapper.custom_mapper.CustomProductMapper;
import com.edu118.po.CustomProduct;
import com.edu118.po.ProductName;

@Service
public class ProductService {
	@Resource
	private ProductMapper productMapper;
	
	@Resource
	private ProductNameMapper productNameMapper;
	
	@Resource
	private CustomProductMapper customProductMapper;
	
	public boolean insertProductNameMapper(ProductName productName) {
		return productNameMapper.insertSelective(productName) > 0 ? true : false;
	}
	
	public List<CustomProduct> selectProduct() {
		return customProductMapper.selectAllProduct();
	}
}
