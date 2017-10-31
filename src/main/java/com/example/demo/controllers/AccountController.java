/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Restaurant;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.AdminRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.AdminService;
import com.example.demo.utils.Login;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailSender;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author User
 */
@RestController
@RequestMapping(path = "/api/account/")
@Api(value = "AccountControllerApi" , produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Autowired
    private AccountService accService;
    @Autowired 
    private AccountRepository adminREpo;
    @Autowired
   private  AdminRepository adminRepo;
    
//    @Value("${MrDfoodApp.email.from}")
//    private String email;
//
//    @Value("${MrDfoodApp.url}")
//    private String url;
//    
//    @Value("${MrDfoodApp.email.support}")
    
    
    
    @RequestMapping(value = "/login/account/getAccount/{id}", method = RequestMethod.GET)
    public Account getOneAccount(@PathVariable("id") long id)
    {
        Account account = accService.getOneAccount(id);
        return account;
    }
    @RequestMapping(value = "/login/allAccounts", method = RequestMethod.GET)
    public List<Account> getAllAccounts()
    {
       List<Account> accounts = accService.getAccounts();
       return accounts;
    }
    
    @RequestMapping(value = "/acc/login", method = RequestMethod.GET)
    @ResponseBody
    public Account adminLogin(@RequestParam String email,@RequestParam String password) {
       
        Account account = accService.getAccount(email, password);
        
        if(account != null)
        {
            return account;
        }
        else{
            return account = null;
        }
        
    }
    @RequestMapping(value = "/login/account/findUserAccount/{userId}",method = RequestMethod.GET)
    public Account getUserAccount(@PathVariable @Valid long userId)
    {
        Account foundAccount = accService.getUserAccount(userId);
        return foundAccount;
    }
  
    
    
}
