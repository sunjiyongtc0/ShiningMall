package com.sjy.shining.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sjy.shining.entity.SysRegionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Mapper
public interface SysRegionDao extends BaseMapper<SysRegionEntity> {

    List<SysRegionEntity> queryList(Map<String, Object> map);


    List<SysRegionEntity> selectAll();

    void saveRegion(SysRegionEntity sysRegionEntity);

    void updateRegion(SysRegionEntity sysRegionEntity);

    void removeRegions(Integer[] ids);

    SysRegionEntity queryObject(Integer id);

    /**
     * 自定义分页查询
     */
    List<SysRegionEntity> queryPage(IPage page, @Param("params") Map<String, Object> params);
}
