package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import com.cy.pj.sys.pojo.SysMenu;
import com.cy.pj.sys.pojo.SysUserMenu;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.vo.Node;

@Mapper
public interface SysMenuDao {
	
	List<Map<String,Object>> findObjects();
	Integer getChildCount(@Param("id") int id);
	Integer deleteObject(@Param("id") int id);
	List<Node> findZtreeMenuNodes();
	Integer insertObject(SysMenu sysMenu);
	Integer updateObject(SysMenu sysMenu);
	List<String> findPermissions(List<Integer> menuIds);
	List<SysUserMenu> findMenusByIds(List<Integer> menuIds);
}
