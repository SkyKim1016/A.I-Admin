package com.onethefull.recipe.comm.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.onethefull.recipe.comm.vo.MailContext;

public class MailServiceTest {
	String[] paths = { "classpath:config/mail-config.xml" };
	ApplicationContext context;
	MailService mailService;
	MailServiceTest() {
		context = new FileSystemXmlApplicationContext(paths);
		mailService = (MailService) context.getBean("mailService");
	}
	
	public void testSendMail() {
		MailContext mailContext = new MailContext();
		mailContext.setFromAddress("sjkim@thirasnc.com");
		mailContext.setToAddress("sjkim@thirasnc.com");
		mailContext.setSubject("테스트입니다.");
		mailContext.setMessage("asdfafa");
		mailService.sendMail(mailContext);
	}

	public static void main(String[] args) {
		MailServiceTest test = new MailServiceTest();
		test.testSendMail();
	}
}
