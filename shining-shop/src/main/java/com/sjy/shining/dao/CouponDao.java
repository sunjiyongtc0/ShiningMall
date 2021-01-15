package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjy.shining.entity.CouponEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Dao
 *
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {


    int saveCo(CouponEntity couponEntity);

    int updateCo(CouponEntity couponEntity);

    List<CouponEntity> queryList(Map<String, Object> map);

    List<CouponEntity> queryList(Object id);

    int queryTotal(Map<String, Object> map);

    int queryTotal();

    CouponEntity queryObject(Object id);
}
