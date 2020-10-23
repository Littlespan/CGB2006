package com.cy.pj.common.searchService;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.common.serviece.Service;


@SpringBootTest
public class SearchService {
	@Autowired
	private Service service;
	
	@Test
	public void TestSearchService() {
		System.out.println(service);
		System.out.println(service.getCache());
	}
	
	
}
