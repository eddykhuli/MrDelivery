/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entities.Driver;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface DriverRepository extends CrudRepository<Driver, Integer>{
    
}
