package com.cy.pj.sys.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuDao {
	Integer deleteObjectsByMenuId(@Param("id") Integer id);
    int insertObjects(Integer roleId,Integer... menuIds);
    void deleteObjectsByRoleId(Integer id);
    Integer[] findMenuIdsByRoleId(Integer id);
    List<Integer> findMenuIdsByRoleIds(Integer[] ids);
}
