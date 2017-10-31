/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entities.PaypalDummy;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface PayPalDummyRepository extends CrudRepository<PaypalDummy, Long> {
   public PaypalDummy findByAccountNumberAndPin(String accountNumber,String pin); 
}
