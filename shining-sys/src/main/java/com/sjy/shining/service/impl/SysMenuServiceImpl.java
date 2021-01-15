package com.sjy.shining.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjy.shining.dao.SysMenuDao;
import com.sjy.shining.dao.SysRegionDao;
import com.sjy.shining.entity.SysMenuEntity;
import com.sjy.shining.entity.SysRegionEntity;
import com.sjy.shining.service.SysMenuService;
import com.sjy.shining.service.SysRegionService;
import com.sjy.shining.service.SysRoleMenuService;
import com.sjy.shining.service.SysUserService;
import com.sjy.shining.utils.Constant.MenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	
	@Override
	public List<SysMenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
		List<SysMenuEntity> menuList = baseMapper.queryListParentId(parentId);
		if(menuIdList == null){
			return menuList;
		}
		List<SysMenuEntity> userMenuList = new ArrayList<>();
		for(SysMenuEntity menu : menuList){
			if(menuIdList.contains(menu.getMenuId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	@Override
	public List<SysMenuEntity> queryNotButtonList() {
		return baseMapper.queryNotButtonList();
	}

	@Override
	public List<SysMenuEntity> getUserMenuList(Long userId) {
		//系统管理员，拥有最高权限
		if(userId == 1){
			return getAllMenuList(null);
		}

		//用户菜单列表
		List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
		return getAllMenuList(menuIdList);
	}
	


	@Override
	public List<SysMenuEntity> queryUserList(Long userId) {
		return baseMapper.queryUserList(userId);
	}

	/**
	 * 获取所有菜单列表
	 */
	private List<SysMenuEntity> getAllMenuList(List<Long> menuIdList){
		//查询根菜单列表
		List<SysMenuEntity> menuList = queryListParentId(0L, menuIdList);
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		
		return menuList;
	}

	/**
	 * 递归
	 */
	private List<SysMenuEntity> getMenuTreeList(List<SysMenuEntity> menuList, List<Long> menuIdList){
		List<SysMenuEntity> subMenuList = new ArrayList<SysMenuEntity>();
		
		for(SysMenuEntity entity : menuList){
			if(entity.getType() == MenuType.CATALOG.getValue()){//目录
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
		}
		return subMenuList;
	}

	@Override
	public List<SysMenuEntity> queryList(Map<String, Object> map) {
		return baseMapper.queryList(map);
	}



	public void  saveMenu(SysMenuEntity sysMenuEntity){
		baseMapper.saveMenu(sysMenuEntity);
	}

	public SysMenuEntity getInfoById(Long id){

		return baseMapper.queryObject(id);
	}

	public void updateMenu(SysMenuEntity sysMenuEntity){

		baseMapper.update(sysMenuEntity);
	}
}
