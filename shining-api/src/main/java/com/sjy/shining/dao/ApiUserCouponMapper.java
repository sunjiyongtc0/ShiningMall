package com.sjy.shining.dao;

import com.sjy.shining.entity.UserCouponVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 */

@Mapper
public interface ApiUserCouponMapper extends BaseDao<UserCouponVo> {
    UserCouponVo queryByCouponNumber(@Param("coupon_number") String coupon_number);
}
