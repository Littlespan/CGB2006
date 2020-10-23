package com.cy.pj.mail.aop;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.stereotype.Component;

import com.cy.pj.mail.annotation.RequiredLog;
/**
 * Spring容器在启动时会基于BeanPostProcessor找到所有的Advisor对象(顾问),并基于
 * Advisor对象中切入点的描述为目标对象创建代理对象.当执行目标方法时会执行Advisor对象
 *   关联通知.
 */
@Component
public class LogAdvisor extends StaticMethodMatcherPointcutAdvisor {
	private static final long serialVersionUID = -3987392064269894257L;
	public LogAdvisor() {
		//在advisor内部注册一个日志通知
		setAdvice(new LogAdvice());
	}
    /**
     * 
     * matches方法用于判定方法参数中的method是否为一个切入点方法,当它的返回值
     * 	为true时,表示参数中的method对象为一个切入点方法.
     * @param method 对应了目标方法对象(可能是目标方法所在类的父类方法对象)
     * @param targetClass 代表目标对象类型
     */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		try {
		    Method targetMethod=
		    targetClass.getMethod(method.getName(), method.getParameterTypes());
		    //检测目标方法上是否有requiredLog注解
		    return targetMethod.isAnnotationPresent(RequiredLog.class);
		}catch(Exception e) {
			return false;
		}
	}

}
