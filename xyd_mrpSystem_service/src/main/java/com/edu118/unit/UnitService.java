package com.edu118.unit;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu118.mapper.UnitMapper;
import com.edu118.po.Unit;
import com.edu118.po.UnitExample;

@Service
public class UnitService {
	@Resource
	private UnitMapper unitMapper;
	
	public List<Unit> selectAll() {
		return unitMapper.selectByExample(new UnitExample() );
	}
}
