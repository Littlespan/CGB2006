package com.cy.pj.common.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import java.util.LinkedHashMap;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/18 10:53
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Configuration
public class SpringShiroConfig {

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager sManager =
				new DefaultWebSecurityManager();
		return sManager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactory(SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean =
				new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		sfBean.setLoginUrl("/doLoginUI");
		LinkedHashMap<String,String> map= new LinkedHashMap<>();
		//静态资源允许匿名访问:"anon"
		map.put("/bower_components/**","anon");
		map.put("/build/**","anon");
		map.put("/dist/**","anon");
		map.put("/plugins/**","anon");
		map.put("/user/doLogin","anon");
		map.put("/doLogout","logout");
		//除了匿名访问的资源,其它都要认证("authc")后访问
		map.put("/**","user");
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}

	@Bean
	public SecurityManager securityManager(
			Realm realm,
			CacheManager cacheManager,
			RememberMeManager rememberMeManager,
			SessionManager sessionManager) {
		DefaultWebSecurityManager sManager=
				new DefaultWebSecurityManager();
		sManager.setRealm(realm);
		sManager.setCacheManager(cacheManager);
		sManager.setRememberMeManager(rememberMeManager);
		sManager.setSessionManager(sessionManager);
		return sManager;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor 
	authorizationAttributeSourceAdvisor (
			SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor=
				new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}

	@Bean
	public CacheManager shiroCacheManager(){
		return new MemoryConstrainedCacheManager();
	}

	@Bean
	public RememberMeManager rememberMeManager() {
		CookieRememberMeManager cManager=
				new CookieRememberMeManager();
		SimpleCookie cookie=new SimpleCookie("rememberMe");
		cookie.setMaxAge(7*24*60*60);
		cManager.setCookie(cookie);
		return cManager;
	}

	@Bean   
	public SessionManager sessionManager() {
			 DefaultWebSessionManager sManager=
					 new DefaultWebSessionManager();
			 sManager.setSessionIdUrlRewritingEnabled(false);
			 sManager.setGlobalSessionTimeout(60*60*1000);
			 return sManager;
	}

}
