package com.cy.pj.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.activity.pojo.Activity;
import com.cy.pj.activity.service.ActivityService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/activity/")
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	 @RequestMapping("doFindActivitys")
	 public String doFindActivitys(Model model) {
		 List<Activity> list=activityService.findActivitys();
		 model.addAttribute("list", list);
		 return "activity";
	 }
	 
	 @RequestMapping("doDeleteObject/{id}")
	 public String doDeleteObject(@PathVariable Integer id) {
		 activityService.deleteById(id);
		 return "redirect:/activity/doFindActivitys";
	 }
	 
	 @RequestMapping("doSaveActivity")
	 public String doSaveActivity(Activity activity) {
		 activityService.insertActivitys(activity);
		 return "redirect:/activity/doFindActivitys";
	 }

	 @RequestMapping("doAjaxActivity")
    @ResponseBody
    public List<Activity> doAjaxActivity() throws Exception{
	     //Thread.sleep(5000);
	     return activityService.findActivitys();
     }
}
