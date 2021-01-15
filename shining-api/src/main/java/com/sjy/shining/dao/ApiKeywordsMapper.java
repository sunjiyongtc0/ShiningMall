package com.sjy.shining.dao;

import com.sjy.shining.entity.KeywordsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 热闹关键词表
 *
 */
@Mapper
public interface ApiKeywordsMapper extends BaseDao<KeywordsVo> {
    List<Map> hotKeywordList(Map param);
}
