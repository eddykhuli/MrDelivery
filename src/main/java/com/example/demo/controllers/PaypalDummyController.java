/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.PaypalDummy;
import com.example.demo.service.PayPalDummyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class PaypalDummyController {
 
     @Autowired
     private PayPalDummyService service;
     
     @RequestMapping(value = "/payment/creditCardpayment" , method = RequestMethod.GET)
     public PaypalDummy verifyAccount(@RequestParam String accountNumber,@RequestParam String pin)
     {
         PaypalDummy paypal = service.getBankAccount(accountNumber, pin);
         return  paypal;
     }
     @RequestMapping(value = "/payment/allAccounts", method = RequestMethod.GET)
     public List<PaypalDummy> getAllAccountInPaypal()
     {
         List<PaypalDummy> accounts = service.getAllAccounts();
         return accounts;
     }
}
