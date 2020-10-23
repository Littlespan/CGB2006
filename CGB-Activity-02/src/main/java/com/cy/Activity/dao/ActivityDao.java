package com.cy.Activity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cy.Activity.pojo.Activity;

@Mapper
public interface ActivityDao {
	@Select("select * from tb_activity")
	List<Activity> findAll();
	
	@Delete("delete from tb_activity where id=#{id}")
	void DeleteById(Long id);
	
	void addActivity(Activity activity);
	
	@Select("select * from tb_activity where id=#{id}")
	Activity findById(Long id);
	
	void UpdateById(Activity activity);
	
	@Update("update tb_activity set state=0 where id=#{id}")
	void UpdateState(Long id);
}
