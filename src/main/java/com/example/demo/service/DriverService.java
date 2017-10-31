/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Driver;
import com.example.demo.repository.DriverRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class DriverService {
    
    @Autowired
    private DriverRepository driverRepo;
    
    public void registerDriver(Driver driver)
    {
        driverRepo.save(driver);
    }
    public List<Driver> getDrivers()
    {
        List<Driver> drivers = new ArrayList<>();
        driverRepo.findAll().forEach(drivers :: add);
        return drivers;
    }
    
}
