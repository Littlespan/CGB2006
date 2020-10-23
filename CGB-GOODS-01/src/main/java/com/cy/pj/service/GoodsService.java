package com.cy.pj.service;

import java.util.List;

import com.cy.pj.pojo.Goods;

public interface GoodsService {
	List<Goods> findAll();
	int deleteById(Integer id);
	int AddGoods(Goods goods);
	Goods findById(Integer id);
	int updateGoods(Goods goods);
}
