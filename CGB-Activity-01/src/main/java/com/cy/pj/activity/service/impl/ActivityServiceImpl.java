package com.cy.pj.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.activity.dao.ActivityDao;
import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityDao activityDao;
	@Override
	public List<Activity> findActivitys() {
		List<Activity> list = activityDao.findActivitys();
		return list;
	}
	@Override
	public void deleteById(Integer id) {
		activityDao.deleteById(id);
	}
	@Override
	public void insertActivitys(Activity activity) {
		activityDao.insertActivitys(activity);
	}

}
