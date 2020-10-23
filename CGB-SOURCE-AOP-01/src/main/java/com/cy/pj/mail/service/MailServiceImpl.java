package com.cy.pj.mail.service;

import org.springframework.stereotype.Service;

import com.cy.pj.mail.annotation.RequiredLog;

@Service
public class MailServiceImpl implements MailService {
	
	@RequiredLog //希望这个注解描述的方法为一个切入点方法(目标方法)
	@Override
	public boolean sendMsg(String msg) {
		//System.out.println("start:"+System.currentTimeMillis());
		System.out.println("send "+msg);
		//System.out.println("end:"+System.currentTimeMillis());
		return true;
	}
}
