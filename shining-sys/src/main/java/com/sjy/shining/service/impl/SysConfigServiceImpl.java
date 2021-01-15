package com.sjy.shining.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysConfigDao;
import com.sjy.shining.entity.SysConfigEntity;
import com.sjy.shining.service.SysConfigService;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import com.sjy.shining.utils.RRException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("sysConfigService")
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao, SysConfigEntity> implements SysConfigService {

	@Override
	public PageUtilsPlus queryPage(Map<String, Object> params) {
		Page<SysConfigEntity> page = new QueryPlus<SysConfigEntity>(params).getPage();
		return new PageUtilsPlus(page.setRecords(baseMapper.queryList(page, params)));
	}


	public void updateValueByKey(String key, String value) {
		baseMapper.updateValueByKey(key, value);
	}
	public String getValue(String key, String defaultValue) {
		String value = baseMapper.queryByKey(key);
		if(StringUtils.isBlank(value)){
			return defaultValue;
		}
		return value;
	}

	public <T> T getConfigObject(String key, Class<T> clazz) {
		String value = getValue(key, null);
		if(StringUtils.isNotBlank(value)){
			return JSON.parseObject(value, clazz);
		}

		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new RRException("获取参数失败");
		}
	}
}
