package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysRoleDeptDao;
import com.sjy.shining.entity.SysRoleDeptEntity;
import com.sjy.shining.service.SysRoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 角色与部门对应关系
 *
 */
@Service("sysRoleDeptService")
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptDao, SysRoleDeptEntity> implements SysRoleDeptService {


    @Override
    @Transactional
    public void saveOrUpdate(Long roleId, List<Long> deptIdList) {
        //先删除角色与菜单关系
        baseMapper.delete(roleId);
        if (deptIdList.size() == 0) {
            return;
        }
        //保存角色与菜单关系
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("deptIdList", deptIdList);
        baseMapper.save(map);
    }

    @Override
    public List<Long> queryDeptIdList(Long roleId) {
        return baseMapper.queryDeptIdList(roleId);
    }

    @Override
    public List<Long> queryDeptIdListByUserId(Long userId) {
        return baseMapper.queryDeptIdListByUserId(userId);
    }

    @Override
    public void delete(long roleId) {
        baseMapper.delete(roleId);
    }


}
