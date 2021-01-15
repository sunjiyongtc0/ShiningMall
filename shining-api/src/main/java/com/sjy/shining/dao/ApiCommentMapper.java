package com.sjy.shining.dao;

import com.sjy.shining.entity.CommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 */
@Mapper
public interface ApiCommentMapper extends BaseDao<CommentVo> {
    int queryhasPicTotal(Map<String, Object> map);
}
