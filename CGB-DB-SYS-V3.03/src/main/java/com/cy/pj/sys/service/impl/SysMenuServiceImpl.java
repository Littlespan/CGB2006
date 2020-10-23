	package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.sys.pojo.SysMenu;
import com.cy.pj.sys.pojo.SysUserMenu;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.util.StringUtils;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    @RequiredLog("查找菜单")
    @Cacheable(value = "menuCache")
    @RequiresPermissions("sys:menu:view")
    public List<Map<String, Object>> findObjects() {
        return sysMenuDao.findObjects();
    }

    @Override
    @RequiresPermissions("sys:menu:delete")
    public int deleteObject(Integer id) {
        if (id == null || id <= 0)
            throw new IllegalArgumentException("请先选择");
        int count = sysMenuDao.getChildCount(id);
        if (count > 0)
            throw new ServiceException("请先删除子菜单");
        sysRoleMenuDao.deleteObjectsByMenuId(id);
        int row = sysMenuDao.deleteObject(id);
        if (row == 0)
            throw new ServiceException("此菜单可能已经不存在");
        return row;
    }

    @Override
    public List<Node> findZtreeMenuNodes() {
        List<Node> list = sysMenuDao.findZtreeMenuNodes();
        return list;
    }

    @Override
    @RequiresPermissions("sys:menu:add")
    public int saveObject(SysMenu sysMenu) {
        if (sysMenu == null)
            throw new IllegalArgumentException("保存对象不能为空");
        if (StringUtils.isEmpty(sysMenu.getName()))
            throw new IllegalArgumentException("菜单名不能为空");

        int rows = sysMenuDao.insertObject(sysMenu);
        return rows;
    }

    @Override
    @CacheEvict(value = "menuCache", allEntries = true)
    @RequiresPermissions("sys:menu:update")
    public int updateObject(SysMenu sysMenu) {
        if (sysMenu == null)
            throw new IllegalArgumentException("保存对象不能为空");
        if (StringUtils.isEmpty(sysMenu.getName()))
            throw new IllegalArgumentException("菜单名不能为空");
        int rows = sysMenuDao.updateObject(sysMenu);
        if (rows == 0)
            throw new ServiceException("记录可能已经不存在");
        return rows;
    }

	@Override
	public List<SysUserMenu> findUserMenusByUserId(Integer id) {
		Integer[] roleIds = sysUserRoleDao.findObjectByUserId(id);
		List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds);
		return sysMenuDao.findMenusByIds(menuIds);
	}

}
