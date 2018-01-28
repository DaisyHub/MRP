package com.edu118.type;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu118.mapper.TypeMapper;
import com.edu118.po.Type;
import com.edu118.po.TypeExample;

@Service
public class TypeService {
	@Resource
	private TypeMapper typeMapper;
	
	public List<Type> selectAll() {
		return typeMapper.selectByExample(new TypeExample() );
	}
	
	public boolean insertType(Type type) {
		return typeMapper.insertSelective(type)>0 ? true : false;
	}
}
