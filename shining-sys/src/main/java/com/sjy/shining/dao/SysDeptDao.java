package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjy.shining.entity.SysDeptEntity;
import com.sjy.shining.entity.UserWindowDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 *
 */
@Mapper
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {

    /**
     * 查询子部门ID列表
     *
     * @param parentId 上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

    SysDeptEntity selectById(long id);


    /**
     * 根据实体条件查询
     *
     * @return
     */
    List<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto);

    List<SysDeptEntity> queryList(Map<String, Object> map);
}
