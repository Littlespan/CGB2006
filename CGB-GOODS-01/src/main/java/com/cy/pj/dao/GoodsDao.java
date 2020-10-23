package com.cy.pj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.pj.pojo.Goods;

@Mapper
public interface GoodsDao {
	
	@Select("select * from tb_goods")
	public List<Goods> findAll();
	
	@Delete("delete from tb_goods where id=#{id}")
	public int deleteById(Integer id);
	
	@Insert("insert into tb_goods values(null,#{name},#{remark},now())")
	public int AddGoods(Goods goods);
	
	@Select("select * from tb_goods where id=#{id}")
	public Goods findById(Integer id);
	
	@Update("update tb_goods set name=#{name},remark=#{remark} where id=#{id}")
	public int updateGodds(Goods goods);
}
