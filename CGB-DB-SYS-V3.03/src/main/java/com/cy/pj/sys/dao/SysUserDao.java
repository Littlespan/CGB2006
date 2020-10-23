package com.cy.pj.sys.dao;

import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.pojo.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserDao {
    int getRowCount(String username);
    List<SysUserDeptVo> findPageObjects(String username, Integer startIndex, Integer pageSize);

    int validById(Integer id,Integer valid);

    int doSaveObject(SysUserRole sysUserRole);

    SysUserDeptVo findPageObjectById(Integer id);

    int updateObject(SysUserRole sysUserRole);

    SysUserDeptVo findUserByUserName(String username);
    
    int updatePassword(SysUserDeptVo sysUserDeptVo);
}
