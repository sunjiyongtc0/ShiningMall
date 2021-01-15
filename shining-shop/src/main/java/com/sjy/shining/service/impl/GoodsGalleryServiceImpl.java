package com.sjy.shining.service.impl;

import com.sjy.shining.dao.GoodsGalleryDao;
import com.sjy.shining.entity.GoodsGalleryEntity;
import com.sjy.shining.service.GoodsGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("goodsGalleryService")
public class GoodsGalleryServiceImpl implements GoodsGalleryService {
    @Autowired
    private GoodsGalleryDao goodsGalleryDao;

    @Override
    public GoodsGalleryEntity queryObject(Integer id) {
        return goodsGalleryDao.queryObject(id);
    }

    @Override
    public List<GoodsGalleryEntity> queryList(Map<String, Object> map) {
        return goodsGalleryDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return goodsGalleryDao.queryTotal(map);
    }

    @Override
    public int save(GoodsGalleryEntity goodsGallery) {
        return goodsGalleryDao.save(goodsGallery);
    }

    @Override
    public int update(GoodsGalleryEntity goodsGallery) {
        return goodsGalleryDao.update(goodsGallery);
    }

    @Override
    public int delete(Integer id) {
        return goodsGalleryDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return goodsGalleryDao.deleteBatch(ids);
    }
}
