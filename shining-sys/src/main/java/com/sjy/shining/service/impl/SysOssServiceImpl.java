package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysOssDao;
import com.sjy.shining.entity.SysOssEntity;
import com.sjy.shining.service.SysOssService;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 */
@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("sidx", "t.create_date");
        params.put("asc", false);
        Page<SysOssEntity> page = new QueryPlus<SysOssEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.selectSysOssPage(page, params)));
    }
}
