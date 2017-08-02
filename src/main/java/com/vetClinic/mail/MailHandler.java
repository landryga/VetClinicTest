package com.vetClinic.mail;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class MailHandler  {
	
	private JavaMailSender mailSender;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public void handleMessage(String from, String to, String message, String subject) {
    	MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {

                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                mimeMessage.setFrom(new InternetAddress(from));
                mimeMessage.setText(message);
                mimeMessage.setSubject(subject);
            }
        };

        try {
            this.mailSender.send(preparator);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.out.println(ex.getMessage());
        }
    }
	
}
