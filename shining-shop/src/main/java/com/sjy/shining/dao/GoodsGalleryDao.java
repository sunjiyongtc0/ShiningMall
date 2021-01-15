package com.sjy.shining.dao;

import com.sjy.shining.entity.GoodsGalleryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Dao
 *
 */
@Mapper
public interface GoodsGalleryDao extends BaseDao<GoodsGalleryEntity> {
    int deleteByGoodsId(Map<String, Integer> map);
}
