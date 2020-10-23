package com.cy.pj.goods.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface GoodsDao {
	@Delete("delete from tb_goods where id=#{id}")
	public int DeleteById(Integer id);
	
	int deleteobjects(@Param("ids")Integer... ids);
}
