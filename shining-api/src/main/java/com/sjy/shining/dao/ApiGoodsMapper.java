package com.sjy.shining.dao;

import com.sjy.shining.entity.GoodsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 */
@Mapper
public interface ApiGoodsMapper extends BaseDao<GoodsVo> {

    List<GoodsVo> queryHotGoodsList(Map<String, Object> params);

    List<GoodsVo> queryCatalogProductList(Map<String, Object> params);
}
