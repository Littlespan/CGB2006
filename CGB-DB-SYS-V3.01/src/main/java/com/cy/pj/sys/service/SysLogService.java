package com.cy.pj.sys.service;


import com.cy.pj.common.bo.PageObject;
import com.cy.pj.sys.pojo.SysLog;

public interface SysLogService {

	PageObject<SysLog> findPageObjects(
			 String username,
			 Integer pageCurrent);
    void deleteObjects(Integer... ids);
}
