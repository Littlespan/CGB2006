package com.cy.pj.sys.dao;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.pojo.SysLog;

@Mapper
public interface SysLogDao {
	int getRowCount(@Param("username") String username);
	List<SysLog> findPageObjects(
			@Param("username")String  username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
    void deleteObjects(@Param("ids") Integer... ids);

}
