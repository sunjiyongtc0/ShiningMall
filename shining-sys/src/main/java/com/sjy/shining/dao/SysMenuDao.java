package com.sjy.shining.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sjy.shining.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 *
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 查询用户的权限列表
     */
    List<SysMenuEntity> queryUserList(Long userId);

    List<SysMenuEntity> queryList(Map<String ,Object> map);

    void saveMenu(SysMenuEntity sysMenuEntity);

    void update(SysMenuEntity sysMenuEntity);

    SysMenuEntity queryObject(Long id);
}
