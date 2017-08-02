package com.vetClinic.admin;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.vetClinic.DAO.UsersDAOimpl;
import com.vetClinic.dbhelper.DBconfig;
import com.vetClinic.mail.MailConfigurer;
import com.vetClinic.mail.MailHandler;
import com.vetClinic.todo.Todo;

@Service
public class AdminService {
	
	public void addUser(UserMaintainer userMaintainer) {
		
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		
		String password = sb.toString();
		
		userMaintainer.setPassword(password);
		
		MailConfigurer conf = new MailConfigurer();
		
		JavaMailSenderImpl impl = conf.setMailSender();
		
		MailHandler handler = new MailHandler();
		
		handler.setMailSender(impl);
		
		handler.handleMessage("testdevpw@gmail.com", userMaintainer.getEmail(), "Your password is " + password, "Your password to VetClinic");
		
		DBconfig db = new DBconfig();
		
		UsersDAOimpl userdao = new UsersDAOimpl();
		
		userdao.saveOrUpdate(userMaintainer);
	}
}
