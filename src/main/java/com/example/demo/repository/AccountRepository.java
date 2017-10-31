/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entities.Account;
import com.example.demo.utils.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface AccountRepository extends CrudRepository<Account, Long>{
     //@Query("SELECT t FROM Todo t WHERE t.title = 'title'")
    public Account findOneByEmailAndPassword(String email,String password);
    public Account findOneByUserId(long userId);
}
