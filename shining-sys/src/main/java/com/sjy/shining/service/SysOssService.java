package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysOssEntity;
import com.sjy.shining.utils.PageUtilsPlus;

import java.util.Map;

/**
 * 文件上传Service
 *
 */
public interface SysOssService extends IService<SysOssEntity> {

    /**
     * queryPage
     *
     * @param params
     * @return
     */
    PageUtilsPlus queryPage(Map<String, Object> params);
}
