/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Account;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author User
 */
@Service
public class NotificationService {
    
  
    private JavaMailSender mailSender;
    
    @Autowired
    public NotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
      
//   public void sendEMail(Account account ) throws MailException
//   {
//       SimpleMailMessage mail = new SimpleMailMessage();
//       mail.setTo(account.getEmail());
//       mail.setFrom("ekthobela@gmail.com");
//       mail.setSubject("Password");
//       mail.setText("Your Request has been succesfully processed and your Account activated...use "+account.getEmail()+" and "+account.getPassword()+"to login");
//       
//       mailSender.send(mail);
//   }
//   
//   public void sendEMailConfirmation() throws MailException, AddressException, MessagingException
//   {
//        final String username = "ekthobela@gmail.com";
//		final String password = "khulile7_";
//                
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//                
//		Session session = Session.getInstance(props,
//		  new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		  });
//                        Message message = new MimeMessage(session);
//                        
//			message.setFrom(new InternetAddress("ekthobela@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse("bgthobela@gmail.com"));
//			message.setSubject("Account Confirmation");
//			message.setText("Your Request has been succesfully processed and your Account activated...use  and account.getPassword()+");
//
//			Transport.send(message);
//        
//   }
//    
//  
   public String sendEmailRe()
   {
        try {
            sendEmail();
            return "Email Sent!";

        }catch(Exception ex) {

            return "Error in sending email: "+ex;

        }

    }

 

    private void sendEmail() throws Exception{

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("bgthobela@gmail.com");

        helper.setSubject("Account Confirmation");
	helper.setText("Your Request has been succesfully processed and your Account activated...use  and account.getPassword()+");

        mailSender.send(message);
    }
}

       
       
       
       
   

