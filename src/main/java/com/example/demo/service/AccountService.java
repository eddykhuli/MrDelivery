/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Admin;
import com.example.demo.entities.Restaurant;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.AdminRepository;
import com.example.demo.utils.Login;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accRepo;
    @Autowired
    private AdminRepository adminRepo;
    
    
    public Account getAccount(String email, String password) {
        return accRepo.findOneByEmailAndPassword(email, password);

    }
    
    public Account getOneAccount(long id)
    {
        Account account = accRepo.findOne(id);
        return account;
    }

    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        accRepo.findAll().forEach(accounts::add);
        return accounts;
    }
    public Account getUserAccount(long userId)
    {
        Account userAccount = accRepo.findOneByUserId(userId);
        return userAccount;
    }
    
    

}
