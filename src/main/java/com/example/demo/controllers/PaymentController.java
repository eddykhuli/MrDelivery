/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Payment;
import com.example.demo.service.PaymentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class PaymentController {
    
    @Autowired
    private PaymentService payService;
    
    @RequestMapping(value = "/order/payment" ,method=RequestMethod.POST)
    public Payment makePayment(@RequestBody @Valid Payment pay)
    {
        payService.makePayment(pay);
        return pay;
    }
    
    @RequestMapping(value="/order/getAllOrderPayments" , method =  RequestMethod.GET)
    public List<Payment> getAllPayments()
    {
        List<Payment> payments = payService.getAllPayments();
        return payments;
    }


}
