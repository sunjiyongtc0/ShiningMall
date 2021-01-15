package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 用户与角色对应关系
 *
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {


    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);


    void saveOrUpdate(Long userId, List<Long> roleIdList);

    void delete(Long userId);
}
