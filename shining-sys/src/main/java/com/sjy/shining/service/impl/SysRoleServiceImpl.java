package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysRoleDao;
import com.sjy.shining.dao.SysUserRoleDao;
import com.sjy.shining.entity.SysRoleEntity;
import com.sjy.shining.entity.SysUserEntity;
import com.sjy.shining.entity.SysUserRoleEntity;
import com.sjy.shining.entity.UserWindowDto;
//import com.sjy.shining.page.Page;
//import com.sjy.shining.page.PageHelper;
import com.sjy.shining.service.*;
import com.sjy.shining.utils.Constant;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import com.sjy.shining.utils.RRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 角色
 *
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleDeptService sysRoleDeptService;

    public SysRoleEntity getInfoById(long id){
        SysRoleEntity sysRoleEntity=baseMapper.queryObject(id);
        sysRoleEntity.setMenuIdList(sysRoleMenuService.queryMenuIdList(id));
        return sysRoleEntity;
    }


    @Override
    @Transactional
    public boolean saveRole(SysRoleEntity role) {
        role.setCreateTime(new Date());
        List<Long> MenuIdList=role.getMenuIdList();
        role.setMenuIdList(null);
        List<Long> DeptIdList =role.getDeptIdList();
        role.setDeptIdList(null);
        role.setDeptName(null);
        this.save(role);
        //检查权限是否越权
        checkPrems(role);
        //保存角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), MenuIdList);
        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), DeptIdList);
        return true;
    }

    @Override
    @Transactional
    public boolean updateRole(SysRoleEntity role) {
        List<Long> MenuIdList=role.getMenuIdList();
        role.setMenuIdList(null);
        List<Long> DeptIdList =role.getDeptIdList();
        role.setDeptIdList(null);
        role.setDeptName(null);
        this.updateById(role);
        //检查权限是否越权
        checkPrems(role);

        //更新角色与菜单关系
        sysRoleMenuService.saveOrUpdate(role.getRoleId(), MenuIdList);
        //保存角色与部门关系
        sysRoleDeptService.saveOrUpdate(role.getRoleId(), DeptIdList);
        return  true;
    }



    @Override
    public List<Long> queryRoleIdList(Long createUserId) {
        return baseMapper.queryRoleIdList(createUserId);
    }

    @Override
    public List<SysRoleEntity> queryList(Map<String, Object> map) {
        return baseMapper.queryList(map);
    }

    @Override
    public PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("asc", false);
        Page<SysRoleEntity> page = new QueryPlus<SysRoleEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.queryList(page, params)));
    }


    /**
     * 检查权限是否越权
     */
    private void checkPrems(SysRoleEntity role) {
        //如果不是超级管理员，则需要判断角色的权限是否超过自己的权限
        if (role.getCreateUserId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户所拥有的菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(role.getCreateUserId());

        //判断是否越权
        if (!menuIdList.containsAll(role.getMenuIdList())) {
            throw new RRException("新增角色的权限，已超出你的权限范围");
        }
    }

//    @Override
//    public Page<UserWindowDto> queryPageByDto(UserWindowDto userWindowDto, int pageNum) {
//        PageHelper.startPage(pageNum, Constant.pageSize);
//        sysRoleDao.queryPageByDto(userWindowDto);
//        return PageHelper.endPage();
//    }

     public void deleteByIds(Long[] ids){
         baseMapper.deleteBatchIds(Arrays.asList(ids));
         for(int i=0;i<ids.length;i++){
             sysRoleMenuService.delete(ids[i]);
             sysRoleDeptService.delete(ids[i]);
         }
     }
}
