package com.cy.pj.sys.controller;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.pojo.SysUserRole;
import com.cy.pj.sys.pojo.UpdatePwd;
import com.cy.pj.sys.service.SysUserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/14 14:47
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Controller
@RequestMapping("/user/")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @ResponseBody
    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username,int pageCurrent){
        return new JsonResult(sysUserService.findPageObjects(username,pageCurrent));
    }

    @RequestMapping("doValidById")
    @ResponseBody
    public JsonResult doValidById(Integer id,Integer valid){
        sysUserService.validById(id,valid);
        return new JsonResult("更新完成");
    }

    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(SysUserRole sysUserRole){
        sysUserService.saveObject(sysUserRole);
        return new JsonResult("保存成功");
    }

    @RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id){
        return new JsonResult(sysUserService.findPageObjectById(id));
    }

    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(SysUserRole sysUserRole){
        sysUserService.updateObject(sysUserRole);
        return new JsonResult("更新成功");
    }
    
    @RequestMapping("doLogin")
    @ResponseBody
	   public JsonResult doLogin(String username,String password,boolean isRememberMe){
		   //1.获取Subject对象
		   //2.通过Subject提交用户信息,交给shiro框架进行认证操作
		   //2.1对用户进行封装
		   UsernamePasswordToken token=
		   new UsernamePasswordToken(
				   username,//身份信息
				   password);//凭证信息
		   //2.2对用户信息进行身份认证
		   if(isRememberMe) {
				token.setRememberMe(true); 
			 }
		   Subject subject=SecurityUtils.getSubject();
		   subject.login(token);
		   //分析:
		   //1)token会传给shiro的SecurityManager
		   //2)SecurityManager将token传递给认证管理器
		   //3)认证管理器会将token传递给realm
		   return new JsonResult("login ok");
	   }
    
    @RequestMapping("doUpdatePassword")
    @ResponseBody
    public JsonResult doUpdatePassword(UpdatePwd updaPwd) {
    	sysUserService.doUpdatePassword(updaPwd);
		return new JsonResult("密码修改完成");
    }

}
