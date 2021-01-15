package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysRoleMenuDao;
import com.sjy.shining.entity.SysRoleMenuEntity;
import com.sjy.shining.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 角色与菜单对应关系
 *
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {


    @Override
    @Transactional
    public void saveOrUpdate(Long roleId, List<Long> menuIdList) {
        if (menuIdList.size() == 0) {
            return;
        }
        //先删除角色与菜单关系
        baseMapper.delete(roleId);

        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("menuIdList", menuIdList);
        baseMapper.save(map);
    }

    @Override
    public List<Long> queryMenuIdList(Long roleId) {
        return baseMapper.queryMenuIdList(roleId);
    }


    public void delete(long roleId){
        baseMapper.delete(roleId);
    }

}
