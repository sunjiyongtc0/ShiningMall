package com.sjy.shining.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysUserEntity;
import com.sjy.shining.entity.UserWindowDto;
import com.sjy.shining.utils.PageUtilsPlus;
import org.apache.ibatis.annotations.Mapper;
//import com.platform.page.Page;

import java.util.List;
import java.util.Map;


/**
 * 系统用户
 *
 */
public interface SysUserService  extends IService<SysUserEntity> {


    /**
     * 保存用户
     */
    boolean saveUser(SysUserEntity user);

    /**
     * 修改用户
     */
    boolean updateUser(SysUserEntity user);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 修改密码
     *
     * @param userId      用户ID
     * @param password    原密码
     * @param newPassword 新密码
     */
    int updatePassword(Long userId, String password, String newPassword);

//    /**
//     * 查询用户列表
//     */
//    List<SysUserEntity> queryList(Map<String, Object> map);
    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);


    /**
     * 获取分页数据
     *
     * @param params 查询参数
     * @return Page
     */
    PageUtilsPlus queryPage(Map<String, Object> params);

    SysUserEntity  getInfoById(Long id);


    void deleteByIds(Long[] userIds);
}
