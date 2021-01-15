package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjy.shining.entity.SysRoleDeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 角色与部门对应关系
 *
 */
@Mapper
public interface SysRoleDeptDao extends BaseMapper<SysRoleDeptEntity> {

    /**
     * 根据角色ID，获取部门ID列表
     */
    List<Long> queryDeptIdList(Long roleId);

    /**
     * 根据用户ID获取权限部门列表
     *
     * @param userId
     * @return
     */
    List<Long> queryDeptIdListByUserId(Long userId);

    void delete(long roleId);

    void save( Map<String, Object> map );
}
