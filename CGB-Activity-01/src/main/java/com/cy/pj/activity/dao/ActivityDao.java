package com.cy.pj.activity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.activity.pojo.Activity;

@Mapper
public interface ActivityDao {
	
	@Select("select * from tb_activity")
	public List<Activity> findActivitys();
	
	@Delete("delete from tb_activity where id=#{id}")
	public void deleteById(Integer id);
	
	@Insert("insert into tb_activity(title,category,startTime,endTime,remark,createdTime) " +
            "values(#{title},#{category},#{startTime},#{endTime},#{remark},now())")
	public void insertActivitys(Activity activity);
}
