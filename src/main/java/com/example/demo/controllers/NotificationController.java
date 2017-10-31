/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.service.NotificationService;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(path = "/api/notification/")
@Api(value = "NotificationControllerApi" , produces = MediaType.APPLICATION_JSON_VALUE)
public class NotificationController {
    
    @Autowired
    private NotificationService service;
   
    //private Logger logger = new LoggerFactory.getLogger(NotificationController.class);
    @RequestMapping(value="/sendPasswordToPartner" , method = RequestMethod.POST)
    public String  sendEmail(@RequestBody @Valid Account account)
    {   
       try{
            service.sendEMail(account);
              return "sent Email";
       }
       catch(MailException e){}
        return "error in sending mail :";
       
    }
    
   
}
