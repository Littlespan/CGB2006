package com.cy.Activity.Service;

import java.util.List;

import com.cy.Activity.pojo.Activity;

public interface ActivityService {
	
	List<Activity> FindAll();
	void DeleteById(Long id);
	void addActivity(Activity activity);
	Activity findById(Long id);
	void UpdateById(Activity activity);
}
