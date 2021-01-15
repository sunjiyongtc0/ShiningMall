package com.sjy.shining.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sjy.shining.entity.SysRoleEntity;
import com.sjy.shining.entity.SysRoleMenuEntity;
import com.sjy.shining.entity.UserWindowDto;
import com.sjy.shining.utils.PageUtilsPlus;
import org.apache.ibatis.annotations.Mapper;
//import com.platform.page.Page;

import java.util.List;
import java.util.Map;


/**
 * 角色
 *
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    boolean saveRole(SysRoleEntity role);
    boolean updateRole(SysRoleEntity role);

    SysRoleEntity getInfoById(long id);
    /**
     * 查询用户创建的角色ID列表
     */
    List<Long> queryRoleIdList(Long createUserId);

    List<SysRoleEntity> queryList(Map<String,Object> map);

    /**
     * 分页查询角色审批选择范围
     * @return
     */
//    Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNmu);

    /**
     * 获取分页数据
     *
     * @param params 查询参数
     * @return Page
     */
    PageUtilsPlus queryPage(Map<String, Object> params);

    void deleteByIds(Long[] ids);
}
