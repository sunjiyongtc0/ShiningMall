package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sjy.shining.entity.SysRoleEntity;
import com.sjy.shining.entity.SysUserEntity;
import com.sjy.shining.entity.UserWindowDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {

    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);

    /**
     * 查询角色审批选择范围
     * @return
     */
    List<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto);

    List<SysRoleEntity> queryList(IPage page, @Param("params") Map<String, Object> params);

    List<SysRoleEntity> queryList(@Param("params") Map<String, Object> params);

    SysRoleEntity queryObject(long id);
}
