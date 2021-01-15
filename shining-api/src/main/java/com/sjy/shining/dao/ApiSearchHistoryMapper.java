package com.sjy.shining.dao;

import com.sjy.shining.entity.SearchHistoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 */
@Mapper
public interface ApiSearchHistoryMapper extends BaseDao<SearchHistoryVo> {
    int deleteByUserId(@Param("user_id") Long userId);
}
