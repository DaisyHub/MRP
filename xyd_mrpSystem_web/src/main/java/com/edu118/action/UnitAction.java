package com.edu118.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu118.po.Unit;
import com.edu118.unit.UnitService;
import com.edu118.vo.DataResult;

@RestController
public class UnitAction {
	@Resource
	private UnitService unitService;
	
	@RequestMapping("getAllUnit")
	public DataResult<List<Unit>> getAllUnit() {
		DataResult<List<Unit>> dataResult = new DataResult<>();
		dataResult.setData(unitService.selectAll());
		return dataResult;
	}
	
}
