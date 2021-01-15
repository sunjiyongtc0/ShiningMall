package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sjy.shining.entity.SysMacroEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 通用字典表Dao
 *
 */
@Mapper
public interface SysMacroDao extends BaseMapper<SysMacroEntity> {

    /**
     * 查询数据字段
     *
     * @param value
     * @return
     */
    List<SysMacroEntity> queryMacrosByValue(@Param("value") String value);

    List<SysMacroEntity> queryList(Map<String, Object> map);

    List<SysMacroEntity> queryList(IPage page, @Param("params") Map<String, Object> params);
}
