package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.CouponEntity;
import com.sjy.shining.utils.R;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 */
public interface CouponService  extends IService<CouponEntity> {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    CouponEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<CouponEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param coupon 实体
     * @return 保存条数
     */
    int saveCo(CouponEntity coupon);

    /**
     * 根据主键更新实体
     *
     * @param coupon 实体
     * @return 更新条数
     */
    int updateCo(CouponEntity coupon);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);

    /**
     * 按用户、商品下发优惠券
     *
     * @param params
     * @return
     */
    R publish(Map<String, Object> params);
}
