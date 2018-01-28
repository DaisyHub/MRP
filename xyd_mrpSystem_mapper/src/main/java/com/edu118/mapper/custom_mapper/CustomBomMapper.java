package com.edu118.mapper.custom_mapper;

import java.util.List;
import java.util.Map;

import com.edu118.po.CustomBomBean;

public interface CustomBomMapper {

	int insertManyBOM(Map<String, Object> map);
	
	List<CustomBomBean> selectBomData(Integer productId);
}
