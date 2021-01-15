package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysRoleEntity;
import com.sjy.shining.entity.SysSmsLogEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 发送短信日志Service
 *
 */
public interface SysSmsLogService extends IService<SysSmsLogEntity> {



    /**
     * 发送短信
     *
     * @param smsLog
     * @return
     */
    SysSmsLogEntity sendSms(SysSmsLogEntity smsLog);
}
