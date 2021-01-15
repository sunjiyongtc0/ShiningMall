package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysLogDao;
import com.sjy.shining.entity.SysLogEntity;
import com.sjy.shining.service.SysLogService;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 *
 */
@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "create_date");
        params.put("asc", false);
        Page<SysLogEntity> page = new QueryPlus<SysLogEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.selectSysLogPage(page, params)));
    }
}
