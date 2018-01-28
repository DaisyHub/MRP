package com.edu118.repository;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edu118.mapper.PartsMapper;
import com.edu118.mapper.custom_mapper.CustomPartsMapper;
import com.edu118.pagingbean.MyPagin;
import com.edu118.po.Parts;
import com.edu118.po.PartsExample;
import com.edu118.po.PartsExample.Criteria;

@Service
public class PartsService {
	@Resource
	private PartsMapper partsMapper;

	@Resource
	private CustomPartsMapper customPartsMapper;

	// 添加配件数据
	public boolean insertParts(Parts parts) {
		return partsMapper.insertSelective(parts) > 0 ? true : false;
	}

	public List<Parts> selectAllParts() {
		return partsMapper.selectByExample(new PartsExample());
	}

	/**
	 * 查询配件的库存余量
	 */
	public Integer getPartsSurplusCount(Map<String, Object> map) {
		return customPartsMapper.selectPartsSurplusCount(map);
	}

	/**
	 * 批量添加配件数据
	 */
	public int insertManyParts(Map<String, Object> map) {
		return customPartsMapper.insertManyParts(map);
	}
	
	public List<Parts> queryLikeParts(Map<String, Object> map, MyPagin myPagin){
		PartsExample example = new PartsExample();
		try {
			example.setMyPagin(myPagin);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//添加模糊查询的条件
			Criteria criteria = example.createCriteria().andPartsDanhaoLike("%" + map.get("pdKword") + "%")
			.andSupplierIdLike("%" + map.get("supplierKword") +"%")
			.andTypeNumLike("%"+ map.get("typeKword") + "%")
			.andDateBetween(sdf.parse(map.get("startDate")+""), sdf.parse(map.get("endDate")+""));
			
			//0代表查询全部，但数据库的flag只有入库1，出库2
			if(!"0".equals(map.get("flag"))) {
				criteria.andFlagEqualTo(Integer.parseInt(map.get("flag")+""));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partsMapper.selectByExample(example);
	}

	//查询符合条件的总数量
	public long queryLikePartsCount(Map<String, Object> map, MyPagin myPagin) {
		PartsExample example = new PartsExample();
		try {
			example.setMyPagin(myPagin);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//添加模糊查询的条件
			Criteria criteria = example.createCriteria().andPartsDanhaoLike("%" + map.get("pdKword") + "%")
			.andSupplierIdLike("%" + map.get("supplierKword") +"%")
			.andTypeNumLike("%"+ map.get("typeKword") + "%")
			.andDateBetween(sdf.parse(map.get("startDate")+""), sdf.parse(map.get("endDate")+""));
			
			//0代表查询全部，但数据库的flag只有入库1，出库2
			if(!"0".equals(map.get("flag"))) {
				criteria.andFlagEqualTo(Integer.parseInt(map.get("flag")+""));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return partsMapper.countByExample(example);
	}
}
