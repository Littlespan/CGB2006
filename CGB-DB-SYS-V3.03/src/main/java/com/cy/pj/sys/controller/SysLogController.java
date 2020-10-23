package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.SysLogService;

@Controller
@RequestMapping("/log/")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username , Integer pageCurrent) {
		return new JsonResult(sysLogService.findPageObjects(username, pageCurrent));
	}
	
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {
		return new JsonResult(sysLogService.deleteObjects(ids));
	}
}
