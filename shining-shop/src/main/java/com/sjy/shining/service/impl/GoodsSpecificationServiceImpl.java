package com.sjy.shining.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sjy.shining.dao.GoodsSpecificationDao;
import com.sjy.shining.entity.GoodsSpecificationEntity;
import com.sjy.shining.service.GoodsSpecificationService;

/**
 * 商品对应规格表值表Service实现类
 *
 */
@Service("goodsSpecificationService")
public class GoodsSpecificationServiceImpl implements GoodsSpecificationService {
    @Autowired
    private GoodsSpecificationDao goodsSpecificationDao;

    @Override
    public GoodsSpecificationEntity queryObject(Integer id) {
        return goodsSpecificationDao.queryObject(id);
    }

    @Override
    public List<GoodsSpecificationEntity> queryList(Map<String, Object> map) {
        return goodsSpecificationDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return goodsSpecificationDao.queryTotal(map);
    }

    @Override
    public int save(GoodsSpecificationEntity goodsSpecification) {
        return goodsSpecificationDao.save(goodsSpecification);
    }

    @Override
    public int update(GoodsSpecificationEntity goodsSpecification) {
        return goodsSpecificationDao.update(goodsSpecification);
    }

    @Override
    public int delete(Integer id) {
        return goodsSpecificationDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return goodsSpecificationDao.deleteBatch(ids);
    }
}
