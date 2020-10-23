package com.cy.ajax.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AjaxController {
	
	@RequestMapping("doAjaxGet")
	@ResponseBody  // 此方法告诉spring mvc 此方法的返回值不是viewname,可以将其看成是普通字符串		
	public String doAjaxGet() {
		return "Ajax Get Request Result";
	}
	
	
	
	@RequestMapping("dosave")
	@ResponseBody
	public String dosave(String user) {
		if(user.equals("hello")) {
			return "repeat";
		}else {
			return "save ok";
		}
		
	}
}
