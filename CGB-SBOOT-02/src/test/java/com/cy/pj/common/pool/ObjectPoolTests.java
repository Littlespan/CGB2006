package com.cy.pj.common.pool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ObjectPoolTests {
	
	@Autowired
	private ObjectPool op1;
	@Autowired
	private ObjectPool op2;
	
	@Test
	void testObjectPool() {
		System.out.println(op1==op2);
	}
}
