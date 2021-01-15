package com.sjy.shining.service.impl;

import com.sjy.shining.dao.GoodsIssueDao;
import com.sjy.shining.entity.GoodsIssueEntity;
import com.sjy.shining.service.GoodsIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("goodsIssueService")
public class GoodsIssueServiceImpl implements GoodsIssueService {
    @Autowired
    private GoodsIssueDao goodsIssueDao;

    @Override
    public GoodsIssueEntity queryObject(Integer id) {
        return goodsIssueDao.queryObject(id);
    }

    @Override
    public List<GoodsIssueEntity> queryList(Map<String, Object> map) {
        return goodsIssueDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return goodsIssueDao.queryTotal(map);
    }

    @Override
    public int save(GoodsIssueEntity goodsIssue) {
        return goodsIssueDao.save(goodsIssue);
    }

    @Override
    public int update(GoodsIssueEntity goodsIssue) {
        return goodsIssueDao.update(goodsIssue);
    }

    @Override
    public int delete(Integer id) {
        return goodsIssueDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return goodsIssueDao.deleteBatch(ids);
    }
}