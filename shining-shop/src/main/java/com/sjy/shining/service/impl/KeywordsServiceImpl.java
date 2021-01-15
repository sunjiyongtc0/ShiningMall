package com.sjy.shining.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sjy.shining.dao.KeywordsDao;
import com.sjy.shining.entity.KeywordsEntity;
import com.sjy.shining.service.KeywordsService;

/**
 * 热闹关键词表Service实现类
 *
 */
@Service("keywordsService")
public class KeywordsServiceImpl implements KeywordsService {
    @Autowired
    private KeywordsDao keywordsDao;

    @Override
    public KeywordsEntity queryObject(Integer id) {
        return keywordsDao.queryObject(id);
    }

    @Override
    public List<KeywordsEntity> queryList(Map<String, Object> map) {
        return keywordsDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return keywordsDao.queryTotal(map);
    }

    @Override
    public int save(KeywordsEntity keywords) {
        return keywordsDao.save(keywords);
    }

    @Override
    public int update(KeywordsEntity keywords) {
        return keywordsDao.update(keywords);
    }

    @Override
    public int delete(Integer id) {
        return keywordsDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return keywordsDao.deleteBatch(ids);
    }
}
