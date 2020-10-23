package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.RoleMenu;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/12 10:58
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Controller
@RequestMapping("/role/")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String name,int pageCurrent){
        return new JsonResult(sysRoleService.findPageObjects(name,pageCurrent));
    }

    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(SysRole sysRole , Integer... menuIds){
        sysRoleService.saveObject(sysRole,menuIds);
        return new JsonResult("save ok");
    }

    @RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        sysRoleService.deleteObject(id);
        return new JsonResult("delete ok");
    }

    @RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id){
        return new JsonResult(sysRoleService.findObjectById(id));
    }

    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(RoleMenu roleMenu){
        sysRoleService.updateObject(roleMenu);
        return new JsonResult("update ok");
    }

    @RequestMapping("doFindRoles")
    @ResponseBody
    public JsonResult doFindRoles(){
        return new JsonResult(sysRoleService.doFindRoles());
    }
}
