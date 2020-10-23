package com.cy.pj.mail.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
/**
  *  日志通知对象
 */
public class LogAdvice implements MethodInterceptor {
	
	/**切入点对应的目标方法执行之前执行，可以在目标方法执行之前和之后做点拓展业务
	 * @param invocation 连接点对象(封装了要执行的目标方法信息，可以通过反射调用目标方法)
	 * */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("start:"+System.currentTimeMillis());
		Object result=invocation.proceed();//执行目标方法
		System.out.println("end:"+System.currentTimeMillis());
		return result;
	}
}
