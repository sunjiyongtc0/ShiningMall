package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sjy.shining.entity.SysOssEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 文件上传Dao
 *
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {

    /**
     * 自定义分页查询
     *
     * @param page
     * @param params
     * @return
     */
    List<SysOssEntity> selectSysOssPage(IPage page, Map<String, Object> params);
}
