/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
      
   public void sendEMail(Account account ) throws MailException
   {
       SimpleMailMessage mail = new SimpleMailMessage();
       mail.setTo(account.getEmail());
       mail.setFrom("ekthobela@gmail.com");
       mail.setSubject("Password");
       mail.setText("Your Request has been succesfully processed and your Account activated...use "+account.getEmail()+" and "+account.getPassword()+"to login");
       
       mailSender.send(mail);
   }
    
}
