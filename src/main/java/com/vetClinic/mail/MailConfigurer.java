package com.vetClinic.mail;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailConfigurer {

	public JavaMailSenderImpl setMailSender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
		sender.setPort(465);
		sender.setPassword("prababcia");
		sender.setUsername("testdevpw@gmail.com");
		
		Properties mailProperties = new Properties();
	    mailProperties.put("mail.smtp.auth", true);
	    mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    mailProperties.put("mail.smtp.starttls.enable", true);
	    sender.setJavaMailProperties(mailProperties);
	    sender.setProtocol("smtps");
		
		return sender;
	}
}
