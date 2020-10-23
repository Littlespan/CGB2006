package com.cy.pj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AjaxController {
	private List<String> names = new ArrayList<>();
	
	@ResponseBody
	@RequestMapping("doSave")
	public String save(String name) {
		if(names.contains(name)) {
			return "保存失败";
		}else {
			names.add(name);
			return "保存成功";
		}
	}
	
	@RequestMapping("doCheck")
	@ResponseBody
	public String check(String name) {
		if(names.contains(name)) {
			return name+"用户名已存在";
		}else {
			return name+"可以注册";
		}
	}
}
