package com.cy.pj.goods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.pj.goods.pojo.Goods;

@Mapper
public interface  GoodsDao {
	
	@Select("select * from tb_goods")
	List<Goods> findAll();
	
	@Delete("delete from tb_goods where id=#{id}")
	int deleteById(/*@Param("ids")*/Integer id);
	
	@Insert("insert into tb_goods values(null,#{name},#{remark},now())")
	int Add(Goods goods);
	
	@Select("select * from tb_goods where id=#{id}")
	Goods findById(Integer id);
	
	@Update("update tb_goods set name=#{name},remark=#{remark} where id=#{id}")
	int updateById(Goods goods);
	
}
