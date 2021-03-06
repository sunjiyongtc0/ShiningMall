package com.sjy.shining.service.impl;

import com.sjy.shining.dao.HelpIssueDao;
import com.sjy.shining.entity.HelpIssueEntity;
import com.sjy.shining.service.HelpIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("helpIssueService")
public class HelpIssueServiceImpl implements HelpIssueService {
    @Autowired
    private HelpIssueDao helpIssueDao;

    @Override
    public HelpIssueEntity queryObject(Integer id) {
        return helpIssueDao.queryObject(id);
    }

    @Override
    public List<HelpIssueEntity> queryList(Map<String, Object> map) {
        return helpIssueDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return helpIssueDao.queryTotal(map);
    }

    @Override
    public int save(HelpIssueEntity helpIssue) {
        return helpIssueDao.save(helpIssue);
    }

    @Override
    public int update(HelpIssueEntity helpIssue) {
        return helpIssueDao.update(helpIssue);
    }

    @Override
    public int delete(Integer id) {
        return helpIssueDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[]ids) {
        return helpIssueDao.deleteBatch(ids);
    }
}
