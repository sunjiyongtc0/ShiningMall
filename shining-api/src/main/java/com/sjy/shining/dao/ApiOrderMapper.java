package com.sjy.shining.dao;

import com.sjy.shining.entity.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 */
@Mapper
public interface ApiOrderMapper extends BaseDao<OrderVo> {

    /**
     * 根据订单编号查询订单
     *
     * @param order_sn
     * @return
     */
    OrderVo queryObjectByOrderSn(@Param("orderSn") String order_sn);
}
