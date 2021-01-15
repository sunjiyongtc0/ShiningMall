package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysLogEntity;
import com.sjy.shining.utils.PageUtilsPlus;
import org.apache.ibatis.annotations.Mapper;
//import com.sjy.shining.utils.PageUtilsPlus;

import java.util.Map;

/**
 * 系统日志
 *
 */
public interface SysLogService extends IService<SysLogEntity> {
    /**
     * 分页
     *
     * @param params
     * @return
     */
    PageUtilsPlus queryPage(Map<String, Object> params);
}
