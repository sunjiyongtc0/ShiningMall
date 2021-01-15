package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysUserRoleDao;
import com.sjy.shining.entity.SysUserRoleEntity;
import com.sjy.shining.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户与角色对应关系
 *
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {


    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return baseMapper.queryRoleIdList(userId);
    }
    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {
        if (roleIdList.size() == 0) {
            return;
        }

        //先删除用户与角色关系
        baseMapper.delete(userId);
        //保存用户与角色关系
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("roleIdList", roleIdList);
        baseMapper.save(map);
    }

    @Override
    public void delete(Long userId) {
        baseMapper.delete(userId);
    }
}

