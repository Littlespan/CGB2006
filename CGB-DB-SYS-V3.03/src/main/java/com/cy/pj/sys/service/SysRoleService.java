package com.cy.pj.sys.service;

import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.common.vo.RoleMenu;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.pojo.checkBox;

import java.util.List;


public interface SysRoleService {
    PageObject<SysRole> findPageObjects(String name, int pageCurrent);
    void saveObject(SysRole sysRole,Integer... menuIds);
    void deleteObject(Integer id);
    RoleMenu findObjectById(Integer id);
    int updateObject(RoleMenu roleMenu);
    List<checkBox> doFindRoles();
}
