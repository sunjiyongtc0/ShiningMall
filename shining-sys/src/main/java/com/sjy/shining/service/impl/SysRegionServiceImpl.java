package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysRegionDao;
import com.sjy.shining.entity.SysRegionEntity;
import com.sjy.shining.service.SysRegionService;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 */
@Service("sysRegionService")
public class SysRegionServiceImpl extends ServiceImpl<SysRegionDao, SysRegionEntity> implements SysRegionService {

    public List<SysRegionEntity> queryList(Map<String, Object> map){
        return baseMapper.queryList(map);
    }

    public List<SysRegionEntity>  selectAll(){
        return baseMapper.selectAll();
    }
    public void  saveRegion(SysRegionEntity sysRegionEntity){
        baseMapper.saveRegion(sysRegionEntity);
    }

    public void  updateRegion(SysRegionEntity sysRegionEntity){
        baseMapper.updateRegion(sysRegionEntity);
    }

    public void  removeRegions(Integer id){
        baseMapper.deleteById(id);
    }
    public SysRegionEntity getInfoById(Integer id){
        return baseMapper.queryObject(id);
    }

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "create_date");
        params.put("asc", false);
        Page<SysRegionEntity> page = new QueryPlus<SysRegionEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.queryPage(page,params)));
    }
}
