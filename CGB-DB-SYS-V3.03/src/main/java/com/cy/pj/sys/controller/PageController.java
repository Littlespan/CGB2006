package com.cy.pj.sys.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.common.utils.ShiroUtils;
import com.cy.pj.common.vo.SysUserDeptVo;
import com.cy.pj.sys.pojo.SysUserMenu;
import com.cy.pj.sys.service.SysMenuService;
import com.cy.pj.sys.service.SysUserService;

@Controller
@RequestMapping("/")
public class PageController {
		@Autowired
		private SysMenuService sysMenuService;
	@RequestMapping("doIndexUI")
	public String doIndexUI(Model model) {
		SysUserDeptVo user = ShiroUtils.getUser();
		model.addAttribute("user",user);
		List<SysUserMenu> UserMenus = sysMenuService.findUserMenusByUserId(user.getId());
		model.addAttribute("userMenus", UserMenus);
		return "starter";
	}
	
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return"common/page";
	}
	
	@RequestMapping("doLoginUI")
	public String doLoginUI(){
			return "login";
	}

	
//	@RequestMapping("log/log_list")
//	public String doLogUI() {
//		return "sys/log_list";
//	}
	
//	@RequestMapping("menu/menu_list")
//	public String doMenuUI() {
//		return "sys/menu_list";
//	}
//	
//	@RequestMapping("menu/menu_edit")
//	public String doMenuEditUI() {
//		return "sys/menu_edit";
//	}
	
	@RequestMapping("{module}/{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {
			return "sys/"+moduleUI;
	}

}	
