package com.cy.pj.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.dao.GoodsDao;
import com.cy.pj.pojo.Goods;
import com.cy.pj.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<Goods> findAll() {
		return goodsDao.findAll();
	}

	@Override
	public int deleteById(Integer id) {
		return goodsDao.deleteById(id);
	}

	@Override
	public int AddGoods(Goods goods) {
		int rows = goodsDao.AddGoods(goods);
		return rows;
	}

	@Override
	public int updateGoods(Goods goods) {
		int rows = goodsDao.updateGodds(goods);
		return rows;
	}

	@Override
	public Goods findById(Integer id) {
		return goodsDao.findById(id);
	}

}
