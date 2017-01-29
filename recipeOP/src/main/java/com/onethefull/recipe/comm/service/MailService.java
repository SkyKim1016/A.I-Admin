package com.onethefull.recipe.comm.service;

import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.vo.MailContext;

@Service("mailService")
public class MailService {
	
	private final static Logger logger = LoggerFactory.getLogger(MailService.class);
	
	@Resource(name = "mailSender")
	private MailSender mailSender;
	
	@Async
	public Future<ResultWithData> sendMail(MailContext mailContext) {
		ResultWithData resultWithData = mailSender.sendMail(mailContext);
		return new AsyncResult<ResultWithData>(resultWithData);
	}
	
}
