package com.sjy.shining.dao;

import com.sjy.shining.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Dao
 *
 */
@Mapper
public interface GoodsDao extends BaseDao<GoodsEntity> {
    Integer queryMaxId();
}
