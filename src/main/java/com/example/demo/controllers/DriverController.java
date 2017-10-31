/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Driver;
import com.example.demo.service.DriverService;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(path = "/api/driver/")
@Api(value = "DriverControllerApi" , produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverController {
    
    @Autowired
    private DriverService service;
    
    @RequestMapping(value = "/registerDriver" ,method = RequestMethod.POST)
    public void registerDriver(@RequestBody Driver driver)
    {
        service.registerDriver(driver);
    }
    
    @RequestMapping(value= "/getAllDriverRequests", method = RequestMethod.GET)
    public List<Driver> getDrivers()
    {
        List<Driver> drivers = service.getDrivers();

        return drivers;
    }
    
}
