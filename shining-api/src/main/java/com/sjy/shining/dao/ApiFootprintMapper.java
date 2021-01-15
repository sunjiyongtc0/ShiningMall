package com.sjy.shining.dao;

import com.sjy.shining.entity.FootprintVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 */
@Mapper
public interface ApiFootprintMapper extends BaseDao<FootprintVo> {
    int deleteByParam(Map<String, Object> map);

    List<FootprintVo> shareList(Map<String, Object> map);

	List<FootprintVo> queryListFootprint(String userid);
}
