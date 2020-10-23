package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.bo.PageObject;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.pojo.SysLog;
import com.cy.pj.sys.service.SysLogService;

@Service
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao; 
	
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		 //1.验证参数合法性
		  //1.1验证pageCurrent的合法性，
		  //不合法抛出IllegalArgumentException异常
		  if(pageCurrent==null||pageCurrent<1)
		  throw new IllegalArgumentException("当前页码不正确");
		  //2.基于条件查询总记录数
		  //2.1) 执行查询
		  Integer rowCount=sysLogDao.getRowCount(username);
		  //2.2) 验证查询结果，假如结果为0不再执行如下操作
		  if(rowCount==0)
        throw new ServiceException("系统没有查到对应记录");
		  //3.基于条件查询当前页记录(pageSize定义为2)
		  //3.1)定义pageSize
		  int pageSize=10;
		  //3.2)计算startIndex
		  int startIndex=(pageCurrent-1)*pageSize;
		  //3.3)执行当前数据的查询操作
		  List<SysLog> records=
		  sysLogDao.findPageObjects(username, startIndex, pageSize);
		  //4.对分页信息以及当前页记录进行封装
		  //4.1)构建PageObject对象
		  PageObject<SysLog> pageObject=new PageObject<>();
		  //4.2)封装数据
		  pageObject.setPageCurrent(pageCurrent);
		  pageObject.setPageSize(pageSize);
		  pageObject.setRowCount(rowCount);
		  pageObject.setRecords(records);
         pageObject.setPageCount((rowCount-1)/pageSize +1);
		  //5.返回封装结果。
		  return pageObject;

	}

    @Override
    public void deleteObjects(Integer... ids) {
	    if(ids==null || ids.length<0)
	        throw new IllegalArgumentException("请选择");

	    sysLogDao.deleteObjects(ids);
    }

}
