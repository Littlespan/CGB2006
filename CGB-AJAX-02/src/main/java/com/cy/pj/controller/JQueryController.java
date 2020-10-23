package com.cy.pj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/5 11:40
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Controller
@RequestMapping("/")
public class JQueryController {

@RequestMapping("doAjaxGet")
@ResponseBody
    public String doAjaxGet(String msg){
        return "Jquery Get request result:" + msg.toUpperCase();
    }

    @RequestMapping("doAjaxPost")
    @ResponseBody
    public String doAjaxPost(Integer id,String name){
    return "Jquery Post request result:" + id+"/"+name;
    }

    @RequestMapping("doAjax")
    @ResponseBody
    public String doAjax(Integer id , String title){
    return "Jquery Post request result:" + id+"/"+title;
    }

    @RequestMapping("user")
    @ResponseBody
    public String doUser(Integer ID){
    return "Jquery Get request result:" + ID;
    }
}
