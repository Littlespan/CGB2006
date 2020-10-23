package com.cy.pj.sys.dao;

import com.cy.pj.common.vo.RoleMenu;
import com.cy.pj.sys.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.pojo.checkBox;

import java.util.List;

@Mapper
public interface SysRoleDao {
    int getRowCount(String name);
    List<SysRole> findPageObjects(String name,int startIndex,int pageSize);
    int insertObject(SysRole sysRole);
    int deleteObject(Integer id);
    RoleMenu findObjectById(Integer id);
    int updateObject(RoleMenu roleMenu);
    List<checkBox> doFindRoles();
}
