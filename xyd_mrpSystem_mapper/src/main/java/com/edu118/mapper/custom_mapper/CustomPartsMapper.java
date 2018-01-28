package com.edu118.mapper.custom_mapper;

import java.util.Map;

public interface CustomPartsMapper {
	int insertManyParts(Map<String, Object> map);

	Integer selectPartsSurplusCount(Map<String, Object> map);

}
