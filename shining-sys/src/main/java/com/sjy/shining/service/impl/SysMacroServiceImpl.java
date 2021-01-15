package com.sjy.shining.service.impl;

//import com.sjy.shining.annotation.RedisCache;
//import com.sjy.shining.cache.J2CacheUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysLogDao;
import com.sjy.shining.dao.SysMacroDao;
import com.sjy.shining.entity.SysLogEntity;
import com.sjy.shining.entity.SysMacroEntity;
import com.sjy.shining.service.SysLogService;
import com.sjy.shining.service.SysMacroService;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用字典表Service实现类
 *
 */
@Service("sysMacroService")
public class SysMacroServiceImpl extends ServiceImpl<SysMacroDao, SysMacroEntity> implements SysMacroService {




    @Override
    public List<SysMacroEntity> queryMacrosByValue(String value) {
        return baseMapper.queryMacrosByValue(value);
    }

    @Override
    public List<SysMacroEntity> queryAllParent(Map<String, Object> map) {
        map.put("type", 0);
        return baseMapper.queryList(map);
    }

    public List<SysMacroEntity> queryList(Map<String, Object> map){
        return baseMapper.queryList(map);
    }

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        Page<SysMacroEntity> page = new QueryPlus<SysMacroEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.queryList(page, params)));
    }
}
