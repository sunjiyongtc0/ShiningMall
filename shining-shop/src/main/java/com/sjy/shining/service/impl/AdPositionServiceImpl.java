package com.sjy.shining.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sjy.shining.dao.AdPositionDao;
import com.sjy.shining.entity.AdPositionEntity;
import com.sjy.shining.service.AdPositionService;

/**
 * Service实现类
 *
 */
@Service("adPositionService")
public class AdPositionServiceImpl implements AdPositionService {
    @Autowired
    private AdPositionDao adPositionDao;

    @Override
    public AdPositionEntity queryObject(Integer id) {
        return adPositionDao.queryObject(id);
    }

    @Override
    public List<AdPositionEntity> queryList(Map<String, Object> map) {
        return adPositionDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return adPositionDao.queryTotal(map);
    }

    @Override
    public int save(AdPositionEntity adPosition) {
        return adPositionDao.save(adPosition);
    }

    @Override
    public int update(AdPositionEntity adPosition) {
        return adPositionDao.update(adPosition);
    }

    @Override
    public int delete(Integer id) {
        return adPositionDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return adPositionDao.deleteBatch(ids);
    }
}
