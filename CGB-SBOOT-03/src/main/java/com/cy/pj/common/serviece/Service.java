package com.cy.pj.common.serviece;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cy.pj.common.cache.Cache;
@Component
public class Service {
	
	private Cache cache;

	public Service(@Qualifier("softCache")Cache cache) {
		this.cache=cache;
	}
	
	public Cache getCache() {
		return cache;
	}
}
