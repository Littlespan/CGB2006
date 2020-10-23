package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SysUserRoleDao {
    int deleteObjectsByRoleId(Integer id);
    int insertObjectsByUserId(SysUserRole sysUserRole);
    Integer[] findObjectByUserId(Integer userId);
    int deleteObjectsByUserId(SysUserRole sysUserRole);
}
