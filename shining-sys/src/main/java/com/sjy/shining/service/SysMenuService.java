package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 菜单管理
 *
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId   父菜单ID
     * @param menuIdList 用户菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();

    /**
     * 获取用户菜单列表
     */
    List<SysMenuEntity> getUserMenuList(Long userId);



    /**
     * 查询用户的权限列表
     */
    List<SysMenuEntity> queryUserList(Long userId);


    List<SysMenuEntity> queryList(Map<String, Object> map);


    void  saveMenu(SysMenuEntity sysMenuEntity);

    SysMenuEntity getInfoById(Long id);

    void updateMenu(SysMenuEntity sysMenuEntity);
}
