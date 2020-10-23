package com.cy.pj.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.cy.pj.common.utils.MessageUtils;



@Aspect
@Component
public class SysServiceExceptionHandle {
	@Pointcut("@annotation(com.cy.pj.common.annotation.ServiceExceptionHandle)")
	public void doServiceException() {}

	@Autowired
	private JavaMailSender mailSender;

	@Around("doServiceException()")
	public Object around(ProceedingJoinPoint jp) {
		Object result =null;
		try {
			result = jp.proceed();
		}catch (Throwable e) {
			MessageUtils.SendMessage(e);
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo("hyh199829@163.com");
			message.setFrom("hyh199829@163.com");
			message.setSubject("异常信息");
			message.setText(e.getMessage());
			try {
				mailSender.send(message);
			}catch(MailException ex) {
				System.out.println("邮件发送失败");
			}
		}
		return result;
	}
}
