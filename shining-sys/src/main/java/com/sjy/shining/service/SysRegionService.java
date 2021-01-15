package com.sjy.shining.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysMenuEntity;
import com.sjy.shining.entity.SysRegionEntity;
import com.sjy.shining.utils.PageUtilsPlus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *
 */
public interface SysRegionService extends IService<SysRegionEntity> {

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<SysRegionEntity>  queryList(Map<String, Object> map);

    List<SysRegionEntity>  selectAll();

    void  saveRegion(SysRegionEntity sysRegionEntity);

    void  updateRegion(SysRegionEntity sysRegionEntity);

    void  removeRegions(Integer id);
    /**
     * 分页
     *
     * @param params
     * @return
     */
    PageUtilsPlus queryPage(Map<String, Object> params);

    SysRegionEntity getInfoById(Integer id);

}
