package com.cy.pj.goods.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	private static final Logger log=LoggerFactory.getLogger(GoodsServiceImpl.class);
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Goods> findGoods() {
		long start = System.currentTimeMillis();
		List<Goods> list = goodsDao.findAll();
		long end = System.currentTimeMillis();
		log.info("time:{}" , end-start);
		System.out.println(end-start);
		return list;
	}

	@Override
	public int deleteById(Integer id) {
		int rows = goodsDao.deleteById(id);
		return rows;
	}

	@Override
	public int Add(Goods goods) {
		int rows = goodsDao.Add(goods);
		return rows;
	}

	@Override
	public Goods findById(Integer id) {
		Goods goods=goodsDao.findById(id);
		return goods;
	}

	@Override
	public int updateById(Goods goods) {
		int rows = goodsDao.updateById(goods);
		return rows;
	}
	
}
