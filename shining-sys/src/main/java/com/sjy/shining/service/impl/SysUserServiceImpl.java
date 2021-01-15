package com.sjy.shining.service.impl;

//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysUserDao;
import com.sjy.shining.entity.SysUserEntity;
import com.sjy.shining.entity.UserWindowDto;
//import com.sjy.shining.page.Page;
//import com.sjy.shining.page.PageHelper;
import com.sjy.shining.service.SysRoleService;
import com.sjy.shining.service.SysUserRoleService;
import com.sjy.shining.service.SysUserService;
import com.sjy.shining.utils.Constant;
import com.sjy.shining.utils.PageUtilsPlus;
import com.sjy.shining.utils.QueryPlus;
import com.sjy.shining.utils.RRException;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * 系统用户
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private SysRoleService sysRoleService;



    @Override
    @Transactional
    public boolean saveUser(SysUserEntity user) {
        boolean b=false;
        user.setCreateTime(new Date());
        //sha256加密
        String pass=new Sha256Hash(Constant.DEFAULT_PASS_WORD).toHex();
        user.setPassword(pass);
        List<Long> RoleIdList=user.getRoleIdList();
        user.setRoleIdList(null);
        user.setDeptName(null);
        b=this.save(user);
        //检查角色是否越权
        checkRole(user);
        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), RoleIdList);
        return  b;
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return baseMapper.queryAllMenuId(userId);
    }


    @Override
    @Transactional
    public boolean updateUser(SysUserEntity user) {
        if (StringUtils.isBlank(user.getPassword())) {
            //sha256加密
            String pass=new Sha256Hash(Constant.DEFAULT_PASS_WORD).toHex();
            user.setPassword(pass);
        } else {
            //sha256加密
            String pass=new Sha256Hash(user.getPassword()).toHex();
            user.setPassword(pass);
        }
        List<Long> RoleIdList=user.getRoleIdList();
        user.setRoleIdList(null);
        user.setDeptName(null);
        this.updateById(user);
        //检查角色是否越权
        checkRole(user);
        //保存用户与角色关系
        sysUserRoleService.saveOrUpdate(user.getUserId(), RoleIdList);
        return  true;
    }

    @Override
    public int updatePassword(Long userId, String password, String newPassword) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("password", password);
        map.put("newPassword", newPassword);
        return baseMapper.updatePassword(map);
    }

//    @Override
//    public List<SysUserEntity> queryList(Map<String, Object> map) {
//        return null;
//    }

    /**
     * 检查角色是否越权
     */
    private void checkRole(SysUserEntity user) {
        //如果不是超级管理员，则需要判断用户的角色是否自己创建
        if (user.getCreateUserId() == Constant.SUPER_ADMIN) {
            return;
        }

        //查询用户创建的角色列表
        List<Long> roleIdList = sysRoleService.queryRoleIdList(user.getCreateUserId());

        //判断是否越权
        if (!roleIdList.containsAll(user.getRoleIdList())) {
            throw new RRException("新增用户所选角色，不是本人创建");
        }
    }


//    @Override
//    public List<SysUserEntity> queryList(Map<String, Object> map) {
//        return baseMapper.queryList(map);
//    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return baseMapper.queryTotal(map);
    }


    @Override
    public   PageUtilsPlus queryPage(Map<String, Object> params) {
        //排序
        params.put("asc", false);
        Page<SysUserEntity> page = new QueryPlus<SysUserEntity>(params).getPage();
        return new PageUtilsPlus(page.setRecords(baseMapper.queryList(page, params)));
    }
    @Override
    public SysUserEntity  getInfoById(Long id){
        SysUserEntity sysUserEntity= baseMapper.queryObject(id);
        return sysUserEntity;
    }

    @Override
    public void deleteByIds(Long[] userIds){
        baseMapper.deleteBatchIds(Arrays.asList(userIds));
        for(int i=0;i<userIds.length;i++){
            sysUserRoleService.delete(userIds[i]);
        }
    }

}
