/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Payment;
import com.example.demo.repository.PaymentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */@Service
public class PaymentService {
    
     
     @Autowired
     private PaymentRepository payRepo;
     
     public Payment makePayment(Payment pay)
     {

         Payment newPay = new Payment();
         newPay.setOrderId(pay.getOrderId());
         newPay.setUserId(pay.getUserId());
         newPay.setAmountPayed(pay.getAmountPayed());
         newPay.setStatus(pay.getStatus());
         newPay.setPaymentType(pay.getPaymentType());
         payRepo.save(newPay);
         return pay;
     }
     
     public List<Payment> getAllPayments()
     {
         List<Payment> payments = new ArrayList<>();
         return payments;
     }
}
