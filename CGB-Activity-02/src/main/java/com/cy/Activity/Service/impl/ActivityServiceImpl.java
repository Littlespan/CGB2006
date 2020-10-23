package com.cy.Activity.Service.impl;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.Activity.Service.ActivityService;
import com.cy.Activity.dao.ActivityDao;
import com.cy.Activity.pojo.Activity;

@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	ActivityDao activityDao;
	
	@Override
	public List<Activity> FindAll() {
		List<Activity> list = activityDao.findAll();
		return list;
	}

	@Override
	public void DeleteById(Long id) {
		activityDao.DeleteById(id);
	}

	@Override
	public void addActivity(Activity activity) {
		activityDao.addActivity(activity);
        Timer timer=new Timer();//此对象创建时会在底层启动一个线程,通过此线程对时间进行监控
        //2)执行任务(任务类型为TimerTask类型)
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //在此位置修改活动的状态信息
                System.out.println("开始执行活动状态的修改操作");
                activityDao.UpdateState(activity.getId());
                timer.cancel();
            }
        }, activity.getEndTime());
        //2)借助Java线程池中的任务调度对象(ScheduledExecutorService )去实现
        //3)借助第三方框架去实现(quartz)
	}

	@Override
	public Activity findById(Long id) {
		return activityDao.findById(id);
	}

	@Override
	public void UpdateById(Activity activity) {
		activityDao.UpdateById(activity);
	}
}
