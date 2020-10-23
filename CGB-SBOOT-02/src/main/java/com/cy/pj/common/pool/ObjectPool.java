package com.cy.pj.common.pool;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
//@Scope("prototype")
@Lazy
@Component
public class ObjectPool {
	
	public ObjectPool() {
		System.out.println("ObjectPool");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init()");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("close()");
	}
}
