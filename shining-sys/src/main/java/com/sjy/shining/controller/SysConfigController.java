package com.sjy.shining.controller;

import com.sjy.shining.annotation.SysLog;
import com.sjy.shining.entity.SysConfigEntity;
import com.sjy.shining.service.SysConfigService;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import com.sjy.shining.utils.R;
import com.sjy.shining.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 系统配置信息Controller
 *
 */
@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 所有配置列表
     *
     * @param params 请求参数
     * @return R
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public R list(@RequestParam Map<String, Object> params) {
        System.out.println(params);
        //查询列表数据
        PageUtilsPlus pageUtil = sysConfigService.queryPage(params);
        return R.ok().put("page", pageUtil);

    }


    /**
     * 根据主键获取配置信息
     *
     * @param id 主键
     * @return R
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:config:info")
    public R info(@PathVariable("id") Long id) {
        SysConfigEntity config = sysConfigService.getById(id);

        return R.ok().put("config", config);
    }

    /**
     * 新增配置
     *
     * @param config 配置
     * @return R
     */
    @SysLog("新增配置")
    @RequestMapping("/save")
    @RequiresPermissions("sys:config:save")
    public R save(@RequestBody SysConfigEntity config) {
        ValidatorUtils.validateEntity(config);
        sysConfigService.save(config);
        return R.ok();
    }

    /**
     * 修改配置
     *
     * @param config 配置
     * @return R
     */
    @SysLog("修改配置")
    @RequestMapping("/update")
    @RequiresPermissions("sys:config:update")
    public R update(@RequestBody SysConfigEntity config) {
        ValidatorUtils.validateEntity(config);
        sysConfigService.updateById(config);

        return R.ok();
    }

    /**
     * 删除配置
     *
     * @param ids 主键集
     * @return R
     */
    @SysLog("删除配置")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public R delete(@RequestBody Long[] ids) {
        sysConfigService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
