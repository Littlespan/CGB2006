package com.cy.pj.sys.service;


import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.pojo.SysUserRole;
import com.cy.pj.sys.pojo.UpdatePwd;

public interface SysUserService {
	PageObject<SysUserDeptVo> findPageObjects(String username, Integer pageCurrent);
	int validById(Integer id,Integer valid);
	int saveObject(SysUserRole SysUserRole);
    SysUserDeptVo findPageObjectById(Integer id);
    int updateObject(SysUserRole sysUserRole);
    int doUpdatePassword(UpdatePwd updaPwd);
}
