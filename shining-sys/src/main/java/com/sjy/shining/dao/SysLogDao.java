package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sjy.shining.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 *
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {


    /**
     * 自定义分页查询
     *
     * @param page
     * @param params
     * @return
     */
    List<SysLogEntity> selectSysLogPage(IPage page, @Param("params") Map<String, Object> params);
}
