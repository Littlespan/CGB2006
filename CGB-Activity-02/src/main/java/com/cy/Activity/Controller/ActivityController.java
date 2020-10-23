package com.cy.Activity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.Activity.Service.ActivityService;
import com.cy.Activity.pojo.Activity;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/activity/")
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	 @RequestMapping("doFindActivitysUI")
	 public String doFindActivitysUI(Model model) {
		 List<Activity> list=activityService.FindAll();
		 model.addAttribute("list", list);
		 return "Activity";
	 }
	 
	@RequestMapping("doFindActivitys")
    @ResponseBody
	public List<Activity> doFindActivitys(){
		List<Activity> list = activityService.FindAll();
		return list;
	}
	
	@RequestMapping("doAddActivity")
    @ResponseBody
	public String doAddActivity(Activity activity) {
		activityService.addActivity(activity);
		return "save ok";
	}
	
	@RequestMapping("doDelete")
    @ResponseBody
	public String doDelete(Long id) {
		activityService.DeleteById(id);
		return "delete ok";
	}
	
	@RequestMapping("doUpdate")
	@ResponseBody
	public String doUpdate(Activity activity) {
		activityService.UpdateById(activity);
		return "update ok";
	}
	
	@RequestMapping("findById")
    @ResponseBody
	public Activity findById(Long id) {
		return activityService.findById(id);
		
	}
}
