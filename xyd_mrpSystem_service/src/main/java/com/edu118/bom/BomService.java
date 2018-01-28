package com.edu118.bom;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu118.mapper.custom_mapper.CustomBomMapper;
import com.edu118.po.CustomBomBean;

@Service
public class BomService {
	
	@Resource
	private CustomBomMapper customBomMapper;
	
	public int insertBom(Map<String, Object> map) {
		return customBomMapper.insertManyBOM(map);
	}
	
	public List<CustomBomBean> findBomByProductId(Integer productId){
		return customBomMapper.selectBomData(productId);
	}
}
