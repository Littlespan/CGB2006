package com.cy.pj.sys.controller;

import com.cy.pj.sys.pojo.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.SysMenuService;

@Controller
@RequestMapping("/menu/")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		return new JsonResult(sysMenuService.findObjects());
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysMenuService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doFindZtreeMenuNodes")
	@ResponseBody
	public JsonResult doFindZtreeMenuNodes() {
		sysMenuService.findZtreeMenuNodes();
		return new JsonResult(sysMenuService.findZtreeMenuNodes());
	}

	@RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(SysMenu sysMenu) {
	    sysMenuService.saveObject(sysMenu);
        return new JsonResult("save ok");
    }

    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(SysMenu sysMenu){
	    sysMenuService.updateObject(sysMenu);
	    return new JsonResult("update ok");
    }
}
