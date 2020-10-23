package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.pojo.SysLog;

@Mapper
public interface SysLogDao {
	Long getRowCount(@Param("username") String username);
	
	List<SysLog> findPageObjects(@Param("username") String username,
			@Param("startIndex") Long startIndex,
			@Param("pageSize") Integer pageSize);
	
	int deleteObjects(@Param("ids") Integer... ids);

	int insertObject(SysLog sysLog);
}
