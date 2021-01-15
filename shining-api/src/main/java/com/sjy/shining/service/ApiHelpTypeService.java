package com.sjy.shining.service;

import com.sjy.shining.dao.ApiHelpTypeMapper;
import com.sjy.shining.entity.HelpTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service
public class ApiHelpTypeService {
    @Autowired
    private ApiHelpTypeMapper helpTypeDao;

    public HelpTypeVo queryObject(Integer id) {
        return helpTypeDao.queryObject(id);
    }

    public List<HelpTypeVo> queryList(Map<String, Object> map) {
        return helpTypeDao.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return helpTypeDao.queryTotal(map);
    }

    public int save(HelpTypeVo helpType) {
        return helpTypeDao.save(helpType);
    }

    public int update(HelpTypeVo helpType) {
        return helpTypeDao.update(helpType);
    }

    public int delete(Integer id) {
        return helpTypeDao.delete(id);
    }

    public int deleteBatch(Integer[] ids) {
        return helpTypeDao.deleteBatch(ids);
    }
}
