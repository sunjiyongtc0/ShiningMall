package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.CouponDao;
import com.sjy.shining.dao.CouponGoodsDao;
import com.sjy.shining.dao.UserCouponDao;
import com.sjy.shining.dao.UserDao;
import com.sjy.shining.entity.CouponEntity;
import com.sjy.shining.entity.CouponGoodsEntity;
import com.sjy.shining.entity.UserCouponEntity;
import com.sjy.shining.entity.UserEntity;
import com.sjy.shining.service.CouponService;
import com.sjy.shining.utils.R;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("couponService")
public class CouponServiceImpl  extends ServiceImpl<CouponDao, CouponEntity> implements CouponService {
//    @Autowired
//    private CouponDao couponDao;
    @Autowired
    private UserCouponDao userCouponDao;
    @Autowired
    private CouponGoodsDao couponGoodsDao;
    @Autowired
    private UserDao userDao;

    @Override
    public CouponEntity queryObject(Integer id) {
        return baseMapper.queryObject(id);
    }

    @Override
    public List<CouponEntity> queryList(Map<String, Object> map) {
        return baseMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return baseMapper.queryTotal(map);
    }

    @Override
    public int saveCo(CouponEntity coupon) {
        return baseMapper.saveCo(coupon);
    }

    @Override
    public int updateCo(CouponEntity coupon) {
        return baseMapper.updateCo(coupon);
    }

    @Override
    public int delete(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public R publish(Map<String, Object> params) {
        // 发放方式 0：按订单发放 1：按用户发放 2:商品转发送券 3：按商品发放 4:新用户注册  5：线下发放 6评价好评红包（固定或随机红包）
        Integer sendType = MapUtils.getInteger(params, "sendType");
        Integer couponId = MapUtils.getInteger(params, "couponId");
        if (null == sendType) {
            return R.error("发放方式不能为空");
        }
        if (null == couponId) {
            return R.error("优惠券不能为空");
        }
        if (1 == sendType) {
            String userIds = MapUtils.getString(params, "userIds"); // 下发用户逗号分割
            if (StringUtils.isEmpty(userIds)) {
                return R.error("用户不能为空");
            }
            //是否发送短信通知
            boolean sendSms = "true".equals(MapUtils.getString(params, "sendSms"));
            for (String strUserId : userIds.split(",")) {
                if (StringUtils.isEmpty(strUserId)) {
                    continue;
                }
                Integer userId = Integer.valueOf(strUserId);
                UserCouponEntity userCouponVo = new UserCouponEntity();
                userCouponVo.setUserId(userId);
                userCouponVo.setCouponId(couponId);
                userCouponVo.setCouponNumber("1");
                userCouponVo.setAddTime(new Date());
                userCouponDao.save(userCouponVo);
                if (sendSms) {
                    UserEntity userEntity = userDao.queryObject(userId);
                    // todo 发送短信

                }
            }
        } else if (3 == sendType) {
            String goodsIds = MapUtils.getString(params, "goodsIds"); // 下发商品逗号分割
            if (StringUtils.isEmpty(goodsIds)) {
                return R.error("商品Id不能为空");
            }
            for (String goodsId : goodsIds.split(",")) {
                if (StringUtils.isEmpty(goodsId)) {
                    continue;
                }
                CouponGoodsEntity couponGoodsVo = new CouponGoodsEntity();
                couponGoodsVo.setCouponId(couponId);
                couponGoodsVo.setGoodsId(Integer.valueOf(goodsId));
                couponGoodsDao.save(couponGoodsVo);
            }
        } else {
            return R.error("此类优惠券不支持手动发放");
        }
        return R.ok("发放成功");
    }
}
