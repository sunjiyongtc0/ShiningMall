package com.sjy.shining.service.impl;

import com.sjy.shining.dao.ShippingDao;
import com.sjy.shining.entity.ShippingEntity;
import com.sjy.shining.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("shippingService")
public class ShippingServiceImpl implements ShippingService {
    @Autowired
    private ShippingDao shippingDao;

    @Override
    public ShippingEntity queryObject(Integer id) {
        return shippingDao.queryObject(id);
    }

    @Override
    public List<ShippingEntity> queryList(Map<String, Object> map) {
        return shippingDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return shippingDao.queryTotal(map);
    }

    @Override
    public int save(ShippingEntity shipping) {
        return shippingDao.save(shipping);
    }

    @Override
    public int update(ShippingEntity shipping) {
        return shippingDao.update(shipping);
    }

    @Override
    public int delete(Integer id) {
        return shippingDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return shippingDao.deleteBatch(ids);
    }
}
