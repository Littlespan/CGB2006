package com.cy.pj.goods.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;


@Controller
@RequestMapping("/goods/")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	/**
	  *  基于商品id执行商品删除操作
	 * @param id 商品id,一定要与客户端传过来的参数id名相同.
	 * @return 重定向到doGoodsUI
	 * rest风格:一种软件架构编码风格,其设计的目的主要是在异构系统之间实现兼容(跨平台)
	 * rest风格的url的定义:{a}/{b}/{c},这里的a,b,c分别为变量
	  *   假如希望方法参数的值来自rest风格的url,
	  *   可以使用@PathVariable注解对方法参数进行描述(方法参数名需要和url中{}内部变量名相同)
	 */
	
	@RequestMapping("doGoodsUI")
	public String doGoodsUI(Model model) {
		model.addAttribute("list",goodsService.findGoods());
		return "goods";
	}
	
	@RequestMapping("deleteById/{id}")
	public String deleteById(@PathVariable Integer id) {
		goodsService.deleteById(id);
		return "redirect:/goods/doGoodsUI";
	}
	
	@RequestMapping("goAdd")
	public String addinfo() {
		return "goods-add";
	}
	
	@RequestMapping("doSaveGoods")
	public String saveGoods(Goods goods) {
		goodsService.Add(goods);
		return "redirect:/goods/doGoodsUI";
	}
	
	@RequestMapping("goUpdateInfo/{id}")
	public String goUpDateInfo(@PathVariable Integer id,Model model) {
		Goods goods = goodsService.findById(id);
		model.addAttribute("good",goods);
		return "goods-update";
	}
	
	@RequestMapping("updateById")
	public String updateById(Goods goods) {
		goodsService.updateById(goods);
		return "redirect:/goods/doGoodsUI";
	}
}
