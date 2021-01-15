package com.sjy.shining.controller;

import com.sjy.shining.annotation.SysLog;
import com.sjy.shining.cache.RegionCacheUtil;
import com.sjy.shining.entity.SysMenuEntity;
import com.sjy.shining.entity.SysRegionEntity;
import com.sjy.shining.service.SysRegionService;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.R;
import com.sjy.shining.utils.TreeUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 地址管理Controller
 *
 */
@RestController
@RequestMapping("sys/region")
public class SysRegionController {
    @Autowired
    private SysRegionService sysRegionService;

    /**
     * 查看列表
     *
     * @param params 请求参数
     * @return R
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:region:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        List<SysRegionEntity> regionList = sysRegionService.queryList(params);

        return R.ok().put("list", regionList);
//        //查询列表数据
//        PageUtilsPlus pageUtil = sysRegionService.queryPage(params);
//        return R.ok().put("page", pageUtil);
    }

    /**
     * 根据主键获取信息
     *
     * @param id 主键
     * @return R
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:region:info")
    public R info(@PathVariable("id") Integer id) {
        SysRegionEntity region = sysRegionService.getInfoById(id);
        return R.ok().put("region", region);
    }

    /**
     * 新增地址
     *
     * @param region 地址
     * @return R
     */
    @SysLog("新增地址")
    @RequestMapping("/save")
    @RequiresPermissions("sys:region:save")
    public R save(@RequestBody SysRegionEntity region) {
        sysRegionService.saveRegion(region);
        RegionCacheUtil.sysRegionEntityList=sysRegionService.selectAll();
        return R.ok();
    }

    /**
     * 修改地址
     *
     * @param region 地址
     * @return R
     */
    @SysLog("修改地址")
    @RequestMapping("/update")
    @RequiresPermissions("sys:region:update")
    public R update(@RequestBody SysRegionEntity region) {
        sysRegionService.updateRegion(region);
        RegionCacheUtil.sysRegionEntityList=sysRegionService.selectAll();
        return R.ok();
    }

    /**
     * 删除地址
     *
     * @param ids 主键集
     * @return R
     */
    @SysLog("删除地址")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:region:delete")
    public R delete(@RequestBody Integer id) {
        sysRegionService.removeRegions(id);//(Arrays.asList(ids));
        RegionCacheUtil.sysRegionEntityList=sysRegionService.selectAll();
        return R.ok();
    }

    /**
     * 查询所有国家
     *
     * @return R
     */
    @RequestMapping("/getAllCountry")
    public R getAllCountry() {
        List<SysRegionEntity> list = RegionCacheUtil.getAllCountry();
        return R.ok().put("list", list);
    }

    /**
     * 查询所有省份
     *
     * @return R
     */
    @RequestMapping("/getAllProvice")
    public R getAllProvice(@RequestParam(required = false) Integer areaId) {
        List<SysRegionEntity> list = RegionCacheUtil.getAllProviceByParentId(areaId);
        return R.ok().put("list", list);
    }

    /**
     * 查询所有城市
     *
     * @return R
     */
    @RequestMapping("/getAllCity")
    public R getAllCity(@RequestParam(required = false) Integer areaId) {
        List<SysRegionEntity> list = RegionCacheUtil.getChildrenCity(areaId);
        return R.ok().put("list", list);
    }


    /**
     * 查询所有区县
     *
     * @return R
     */
    @RequestMapping("/getChildrenDistrict")
    public R getChildrenDistrict(@RequestParam(required = false) Integer areaId) {
        List<SysRegionEntity> list = RegionCacheUtil.getChildrenDistrict(areaId);
        return R.ok().put("list", list);
    }

    /**
     * 查看信息(全部加载页面渲染太慢！)
     *
     * @return R
     */
    @RequestMapping("/getAreaTree")
    public R getAreaTree() {
        List<SysRegionEntity> list = RegionCacheUtil.sysRegionEntityList;
        for (SysRegionEntity sysRegionEntity : list) {
            sysRegionEntity.setValue(sysRegionEntity.getId() + "");
            sysRegionEntity.setLabel(sysRegionEntity.getName());
        }
        List<SysRegionEntity> node = TreeUtils.factorTree(list);

        return R.ok().put("node", node);
    }

    /**
     * 根据类型获取区域
     *
     * @param type 类型
     * @return R
     */
    @RequestMapping("/getAreaByType")
    public R getAreaByType(@RequestParam(required = false) Integer type) {

        List<SysRegionEntity> list = new ArrayList<>();
        if (type.equals(0)) {

        } else if (type.equals(1)) {//省份
            list = RegionCacheUtil.getAllCountry();
        } else if (type.equals(2)) {
            list = RegionCacheUtil.getAllProvice();
        } else if (type.equals(3)) {
            list = RegionCacheUtil.getAllCity();
        }
        return R.ok().put("list", list);
    }
}
