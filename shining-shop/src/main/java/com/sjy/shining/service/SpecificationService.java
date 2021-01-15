package com.sjy.shining.service;

import com.sjy.shining.entity.SpecificationEntity;

import java.util.List;
import java.util.Map;

/**
 * 规格表
 *
 */
public interface SpecificationService {
	
	SpecificationEntity queryObject(Integer id);
	
	List<SpecificationEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SpecificationEntity specification);
	
	void update(SpecificationEntity specification);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
