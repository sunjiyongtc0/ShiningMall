package com.sjy.shining.service.impl;

import com.sjy.shining.dao.AttributeCategoryDao;
import com.sjy.shining.entity.AttributeCategoryEntity;
import com.sjy.shining.service.AttributeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("attributeCategoryService")
public class AttributeCategoryServiceImpl implements AttributeCategoryService {
    @Autowired
    private AttributeCategoryDao attributeCategoryDao;

    @Override
    public AttributeCategoryEntity queryObject(Integer id) {
        return attributeCategoryDao.queryObject(id);
    }

    @Override
    public List<AttributeCategoryEntity> queryList(Map<String, Object> map) {
        return attributeCategoryDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return attributeCategoryDao.queryTotal(map);
    }

    @Override
    public int save(AttributeCategoryEntity attributeCategory) {
        return attributeCategoryDao.save(attributeCategory);
    }

    @Override
    public int update(AttributeCategoryEntity attributeCategory) {
        return attributeCategoryDao.update(attributeCategory);
    }

    @Override
    public int delete(Integer id) {
        return attributeCategoryDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return attributeCategoryDao.deleteBatch(ids);
    }
}
