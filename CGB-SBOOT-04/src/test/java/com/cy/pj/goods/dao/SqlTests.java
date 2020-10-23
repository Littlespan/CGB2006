package com.cy.pj.goods.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.goods.pojo.Goods;

@SpringBootTest
public class SqlTests {
	@Autowired
	private GoodsDao mapper;
	
	@Test
	public void findAllTest() {
		List<Goods> list = mapper.findAll();
		for (Goods goods : list) {
			System.out.println(goods);
		}
	}
	
	
}
