package com.sjy.shining.service.impl;

import com.sjy.shining.dao.BrandDao;
import com.sjy.shining.entity.BrandEntity;
import com.sjy.shining.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public BrandEntity queryObject(Integer id) {
        return brandDao.queryObject(id);
    }

    @Override
    public List<BrandEntity> queryList(Map<String, Object> map) {
        return brandDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return brandDao.queryTotal(map);
    }

    @Override
    public int save(BrandEntity brand) {
        return brandDao.save(brand);
    }

    @Override
    public int update(BrandEntity brand) {
        return brandDao.update(brand);
    }

    @Override
    public int delete(Integer id) {
        return brandDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return brandDao.deleteBatch(ids);
    }
}
