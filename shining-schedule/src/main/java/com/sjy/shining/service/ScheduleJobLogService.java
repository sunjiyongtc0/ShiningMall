package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.ScheduleJobLogEntity;
import com.sjy.shining.utils.PageUtilsPlus;
import java.util.Map;

/**
 * 定时任务日志
 *
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

    /**
     * 获取分页数据
     *
     * @param params 查询参数
     * @return Page
     */
    PageUtilsPlus queryPage(Map<String, Object> params);
}
