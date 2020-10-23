package com.cy.pj.sys.service.impl;


import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.annotation.ServiceExceptionHandle;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.pojo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.pojo.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service

public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogDao sysLogDao;
	

	@Override
	@RequiredLog("日志查询")
	@RequiresPermissions("sys:log:view")
	@ServiceExceptionHandle
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		long rows = sysLogDao.getRowCount(username);
		if(rows==0)
			throw new ServiceException("没有数据");
		if(pageCurrent==null||pageCurrent<1) {
			throw new ServiceException("yemabucunzai404");
		}
		int pageSize = 10;
		long startIndex = (pageCurrent-1)*pageSize;
		return new PageObject<>(rows,pageCurrent,pageSize,sysLogDao.findPageObjects(username, startIndex, pageSize));
	}

	@Override
	@RequiresPermissions("sys:log:delete")
	public Integer deleteObjects(Integer... ids) {
		int rows = sysLogDao.deleteObjects(ids);
		return rows;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Async
	public Integer insertObject(SysLog sysLog) throws InterruptedException {
		Thread.sleep(2000);
		int rows = sysLogDao.insertObject(sysLog);
		return rows;
	}
}
