package com.cy;

import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CgbSourceAop01Application {
	//@Bean注解应用于配置类中(使用了@Configuration修饰)
	//@Bean描述的方法其返回值会交给spring管理,spring管理这个bean默认bean名字为方法名
	@Bean 
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		//此对象会在容器启动时扫描Advisor对象,然后基于切入点为目标对象创建代理对象
		//然后再执行切入点方法时,自动执行Advice对象通知方法
		return new DefaultAdvisorAutoProxyCreator();
	}
	public static void main(String[] args) {
		SpringApplication.run(CgbSourceAop01Application.class, args);
	}

}
