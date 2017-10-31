/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.PaypalDummy;
import com.example.demo.repository.PayPalDummyRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class PayPalDummyService {
    
    @Autowired 
    private PayPalDummyRepository payRepo;
    
    public PaypalDummy getBankAccount(String accountNumber,String pin){
        PaypalDummy foundAccount = payRepo.findByAccountNumberAndPin(accountNumber, pin);
        return foundAccount;
    }

    public List<PaypalDummy> getAllAccounts() {
        List<PaypalDummy> accounts = new ArrayList<>();
        payRepo.findAll().forEach(accounts :: add);
        return accounts;
    }
    
}
