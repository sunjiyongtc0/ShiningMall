package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysLogEntity;
import com.sjy.shining.entity.SysMacroEntity;
import com.sjy.shining.utils.PageUtilsPlus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 通用字典表Service接口
 *
 */
public interface SysMacroService extends IService<SysMacroEntity> {



    List<SysMacroEntity> queryMacrosByValue(String value);

    /**
     * 查看字典目录列表
     *
     * @param map
     * @return
     */
    List<SysMacroEntity> queryAllParent(Map<String, Object> map);

    List<SysMacroEntity> queryList(Map<String, Object> map);

    /**
     * 获取分页数据
     *
     * @param params 查询参数
     * @return Page
     */
    PageUtilsPlus queryPage(Map<String, Object> params);
}
