package com.edu118.supplier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu118.mapper.SupplierMapper;
import com.edu118.po.Supplier;
import com.edu118.po.SupplierExample;

@Service
public class SupplierService {
	@Resource
	private SupplierMapper supplierMapper;
	
	public List<Supplier> selectAll() {
		return supplierMapper.selectByExample(new SupplierExample() );
	}
	
	public boolean insertSupplier(Supplier supplier) {
		return supplierMapper.insertSelective(supplier) > 0 ? true : false;
	}
}
