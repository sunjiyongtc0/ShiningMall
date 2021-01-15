package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.ScheduleJobLogDao;
import com.sjy.shining.entity.ScheduleJobLogEntity;
import com.sjy.shining.service.ScheduleJobLogService;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 */
@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogDao, ScheduleJobLogEntity> implements ScheduleJobLogService {

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "T.CREATE_TIME");
        params.put("asc", false);
        Page<ScheduleJobLogEntity> page = new QueryPlus<ScheduleJobLogEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.selectScheduleJobLogPage(page, params)));
    }
}
