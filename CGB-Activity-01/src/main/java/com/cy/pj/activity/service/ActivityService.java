package com.cy.pj.activity.service;

import java.util.List;

import com.cy.pj.activity.pojo.Activity;

public interface ActivityService {
	
	List<Activity> findActivitys();
	void deleteById(Integer id);
	void insertActivitys(Activity activity);
}
