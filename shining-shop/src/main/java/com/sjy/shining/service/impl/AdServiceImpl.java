package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.sjy.shining.dao.AdDao;
import com.sjy.shining.entity.AdEntity;
import com.sjy.shining.service.AdService;

/**
 * Service实现类
 *
 */
@Service("adService")
public class AdServiceImpl extends ServiceImpl<AdDao, AdEntity> implements AdService  {

    @Override
    public AdEntity queryObject(Integer id) {
        return baseMapper.queryObject(id);
    }

    @Override
    public List<AdEntity> queryList(Map<String, Object> map) {
        return baseMapper.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return baseMapper.queryTotal(map);
    }

    @Override
    public int saveAd(AdEntity ad) {
        return baseMapper.saveAd(ad);
    }

    @Override
    public int update(AdEntity ad) {
        return baseMapper.updateAd(ad);
    }

    @Override
    public int delete(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return baseMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
