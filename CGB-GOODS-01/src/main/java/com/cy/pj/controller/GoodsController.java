package com.cy.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.pojo.Goods;
import com.cy.pj.service.GoodsService;

@Controller
@RequestMapping("/goods/")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("doGoodsUI")
	public String doGoodsUI(Model model) {
		model.addAttribute("list", goodsService.findAll());
		return "goods";
	}
	
	@RequestMapping("deleteById/{id}")
	public String doDeleteById(@PathVariable Integer id) {
		goodsService.deleteById(id);
		return "redirect:/goods/doGoodsUI";
	}
	
	@RequestMapping("goAdd")
	public String goAdd() {
		return "goods-add";
	}
	
	@RequestMapping("doSaveGoods")
	public String doSaveGoods(Goods goods) {
		goodsService.AddGoods(goods);
		return "redirect:doGoodsUI";
	}
	
	@RequestMapping("goUpdateInfo/{id}")
	public String goUpdateInfo(@PathVariable Integer id,Model model) {
		Goods goods = goodsService.findById(id);
		model.addAttribute("list", goods);
		return "goods-update";
	}
	
	@RequestMapping("updateById")
	public String updateById(Goods goods) {
		goodsService.updateGoods(goods);
		return "redirect:doGoodsUI";
		
	}
}
