package com.sjy.shining.service;

import com.sjy.shining.dao.ApiHelpIssueMapper;
import com.sjy.shining.entity.HelpIssueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service
public class ApiHelpIssueService {
    @Autowired
    private ApiHelpIssueMapper helpIssueDao;

    public HelpIssueVo queryObject(Integer id) {
        return helpIssueDao.queryObject(id);
    }

    public List<HelpIssueVo> queryList(Map<String, Object> map) {
        return helpIssueDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return helpIssueDao.queryTotal(map);
    }

    public int save(HelpIssueVo helpIssue) {
        return helpIssueDao.save(helpIssue);
    }

    public int update(HelpIssueVo helpIssue) {
        return helpIssueDao.update(helpIssue);
    }

    public int delete(Integer id) {
        return helpIssueDao.delete(id);
    }

    public int deleteBatch(Integer[] ids) {
        return helpIssueDao.deleteBatch(ids);
    }
}
