package com.onethefull.recipe.comm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.onethefull.recipe.comm.ResultWithData;
import com.onethefull.recipe.comm.vo.MailContext;

@Service("mailSender")
public class MailSender {

	private final static Logger logger = LoggerFactory.getLogger(MailSender.class);

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Value("#{mailProperty['mail.username']}")
	private String baseFromAddress;

	@SuppressWarnings("finally")
	public ResultWithData sendMail(final MailContext mailContext) {
		ResultWithData resultWithData = ResultWithData.succcessResult();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(baseFromAddress);
		message.setSubject(mailContext.getSubject());
		message.setText(mailContext.getMessage());
		try {
			if (mailContext.isToAddresses()) {
				for (String toAddress : mailContext.getToAddresses()) {
					message.setTo(toAddress);
					javaMailSender.send(message);
				}
			} else {
				message.setTo(mailContext.getToAddress());
				javaMailSender.send(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultWithData = ResultWithData.failuerResult();
		} finally {
			return resultWithData;
		}
	}

}
