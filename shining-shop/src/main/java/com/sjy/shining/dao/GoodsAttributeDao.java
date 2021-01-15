package com.sjy.shining.dao;

import com.sjy.shining.entity.GoodsAttributeEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 */
@Mapper
public interface GoodsAttributeDao extends BaseDao<GoodsAttributeEntity> {

    int updateByGoodsIdAttributeId(GoodsAttributeEntity goodsAttributeEntity);
}
