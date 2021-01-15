package com.sjy.shining.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sjy.shining.entity.SysConfigEntity;
import com.sjy.shining.entity.SysMacroEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 系统配置信息
 *
 */
@Mapper
public interface SysConfigDao extends BaseMapper<SysConfigEntity> {

    List<SysConfigEntity> queryList(IPage page, @Param("params") Map<String, Object> params);

    /**
     * 根据key，查询value
     */
    String queryByKey(String paramKey);

    /**
     * 根据key，更新value
     *
     * @param key
     * @param value
     * @return
     */
    int updateValueByKey(@Param("key") String key, @Param("value") String value);

}
