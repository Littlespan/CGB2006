package com.cy.pj.sys.service.impl;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.common.vo.RoleMenu;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.pojo.checkBox;
import com.cy.pj.sys.service.SysRoleService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/12 10:50
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    @RequiresPermissions("sys:role:view") 
    public PageObject<SysRole> findPageObjects(String name, int pageCurrent) {
        long rows = sysRoleDao.getRowCount(name);
        if(rows==0)
            throw new ServiceException("你查询的数据不存在");
        if(pageCurrent<=0)
            throw new IllegalArgumentException("您查询的页面不正确");
        int pageSize = 2;
        int startIndex = (pageCurrent-1)*pageSize;
        return new PageObject<>(rows,pageCurrent,pageSize, sysRoleDao.findPageObjects(name,startIndex,pageSize));
    }

    @Override
    @RequiresPermissions("sys:role:add")
    public void saveObject(SysRole sysRole,Integer... menuIds) {
        if(sysRole==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(sysRole.getName()))
            throw new IllegalArgumentException("角色名不能为空");
        if(menuIds==null||menuIds.length==0)
            throw new ServiceException("请为角色分配权限");
        sysRoleDao.insertObject(sysRole);
        sysRoleMenuDao.insertObjects(sysRole.getId(),menuIds);
    }

    @Override
    @RequiresPermissions("sys:role:delete")
    public void deleteObject(Integer id) {
        if(id==0|| id < 1)
            throw new ServiceException("id不能为空");
        if(sysRoleDao.findObjectById(id)==null||sysRoleMenuDao.findMenuIdsByRoleId(id)==null)
            throw new ServiceException("没有数据");
        sysRoleDao.deleteObject(id);
        sysUserRoleDao.deleteObjectsByRoleId(id);
        sysRoleMenuDao.deleteObjectsByRoleId(id);
    }

    @Override
    public RoleMenu findObjectById(Integer id) {
        if(id==0 || id<1)
            throw new ServiceException("id无效");
        if(sysRoleDao.findObjectById(id)==null||sysRoleMenuDao.findMenuIdsByRoleId(id)==null)
            throw new ServiceException("没有数据");
        RoleMenu roleMenu = sysRoleDao.findObjectById(id);
        roleMenu.setMenuIds(sysRoleMenuDao.findMenuIdsByRoleId(id));
        return roleMenu;
    }

    @Override
    @RequiresPermissions("sys:role:update")
    public int updateObject(RoleMenu roleMenu) {
        if(roleMenu==null)
            throw new ServiceException("对象不能为空");
        int rows = sysRoleDao.updateObject(roleMenu);
        sysRoleMenuDao.deleteObjectsByRoleId(roleMenu.getId());
        sysRoleMenuDao.insertObjects(roleMenu.getId(),roleMenu.getMenuIds());
        return rows;
    }

    @Override
    public List<checkBox> doFindRoles() {
        return sysRoleDao.doFindRoles();
    }

}
