package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysRoleDeptEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 角色与部门对应关系
 *
 */
public interface SysRoleDeptService extends IService<SysRoleDeptEntity> {

    void saveOrUpdate(Long roleId, List<Long> deptIdList);

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
}
