package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysConfigEntity;
import com.sjy.shining.entity.SysDeptEntity;
import com.sjy.shining.utils.PageUtilsPlus;

import java.util.Map;

/**
 * 系统配置信息
 *
 */
public interface SysConfigService extends IService<SysConfigEntity> {

    /**
     * 获取分页数据
     *
     * @param params 查询参数
     * @return Page
     */
    PageUtilsPlus queryPage(Map<String, Object> params);


    void updateValueByKey(String key, String value);
//
//    /**
//     * 获取List列表
//     */
//    public List<SysConfigEntity> queryList(Map<String, Object> map);
//
//    /**
//     * 获取总记录数
//     */
//    public int queryTotal(Map<String, Object> map);
//
//    public SysConfigEntity queryObject(Long id);
//
    /**
     * 根据key，获取配置的value值
     *
     * @param key          key
     * @param defaultValue 缺省值
     */
    public String getValue(String key, String defaultValue);

    /**
     * 根据key，获取value的Object对象
     *
     * @param key   key
     * @param clazz Object对象
     */
    public <T> T getConfigObject(String key, Class<T> clazz);

}
