package com.cy.pj.goods.service;

import java.util.List;

import com.cy.pj.goods.pojo.Goods;

public interface GoodsService {
	List<Goods> findGoods();
	int deleteById(Integer id);
	int Add(Goods goods);
	Goods findById(Integer id);
	int updateById(Goods goods);
}
