package com.cy.pj.common.cache;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CacheTests {
	@Autowired
	@Qualifier("softCache")
	private Cache cache;
	
	@Test
	public void TestCache() {
		System.out.println(cache);
	}
}
