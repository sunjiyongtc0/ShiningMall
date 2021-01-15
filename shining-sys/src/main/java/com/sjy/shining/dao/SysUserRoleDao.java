package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjy.shining.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 *
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);

    void delete(long userId);

    void save( Map<String, Object> map);
}
