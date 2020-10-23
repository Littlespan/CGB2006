package com.cy.pj.goods.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.goods.dao.GoodsDao;

@SpringBootTest
public class DeleteByIdTests {
	
	@Autowired
	private GoodsDao goodsdelete;
	
	@Test
	public void deleteById() {
		int rows = goodsdelete.DeleteById(2);
		System.out.println("影响行数：" + rows);
	} 
	
	@Test
	public void deleteObjects() {
		int rows = goodsdelete.deleteobjects(1,2,3);
		System.out.println("影响行数：" + rows);
	}
}
