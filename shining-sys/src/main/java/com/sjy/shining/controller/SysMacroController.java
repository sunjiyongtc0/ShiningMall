package com.sjy.shining.controller;

import com.sjy.shining.annotation.SysLog;
import com.sjy.shining.entity.SysMacroEntity;
import com.sjy.shining.service.SysMacroService;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import com.sjy.shining.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 通用字典表Controller
 *
 */
@RestController
@RequestMapping("sys/macro")
public class SysMacroController {
    @Autowired
    private SysMacroService sysMacroService;

    /**
     * 所有字典列表
     *
     * @param params 请求参数
     * @return R
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:macro:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        PageUtilsPlus pageUtil = sysMacroService.queryPage(params);
        return R.ok().put("page", pageUtil);
    }

    /**
     * 根据主键获取字典信息
     *
     * @param macroId 主键
     * @return R
     */
    @RequestMapping("/info/{macroId}")
    @RequiresPermissions("sys:macro:info")
    public R info(@PathVariable("macroId") Long macroId) {
        SysMacroEntity sysMacro = sysMacroService.getById(macroId);

        return R.ok().put("macro", sysMacro);
    }

    /**
     * 新增字典
     *
     * @param sysMacro 字典
     * @return R
     */
    @SysLog("新增字典")
    @RequestMapping("/save")
    @RequiresPermissions("sys:macro:save")
    public R save(@RequestBody SysMacroEntity sysMacro) {
        sysMacroService.save(sysMacro);

        return R.ok();
    }

    /**
     * 修改字典
     *
     * @param sysMacro 字典
     * @return R
     */
    @SysLog("修改字典")
    @RequestMapping("/update")
    @RequiresPermissions("sys:macro:update")
    public R update(@RequestBody SysMacroEntity sysMacro) {
        sysMacroService.updateById(sysMacro);

        return R.ok();
    }

    /**
     * 删除字典
     *
     * @param macroIds 主键集
     * @return R
     */
    @SysLog("删除字典")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:macro:delete")
    public R delete(@RequestBody Long[] macroIds) {
        sysMacroService.removeByIds(Arrays.asList(macroIds));

        return R.ok();
    }

    /**
     * 查看字典列表
     *
     * @param params 请求参数
     * @return R
     */
    @RequestMapping("/queryAll")
    public R queryAll(@RequestParam Map<String, Object> params) {

        List<SysMacroEntity> list = sysMacroService.queryList(params);

        return R.ok().put("list", list);
    }

    /**
     * 查看字典目录列表
     *
     * @param params 请求参数
     * @return R
     */
    @RequestMapping("/queryAllParent")
    public R queryAllParent(@RequestParam Map<String, Object> params) {

        List<SysMacroEntity> list = sysMacroService.queryAllParent(params);

        return R.ok().put("list", list);
    }

    /**
     * 根据value查询数据字典
     *
     * @param value value
     * @return R
     */
    @RequestMapping("/queryMacrosByValue")
    public R queryMacrosByValue(@RequestParam String value) {

        List<SysMacroEntity> list = sysMacroService.queryMacrosByValue(value);

        return R.ok().put("list", list);
    }
}
