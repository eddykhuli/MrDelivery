/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Admin;
import com.example.demo.repository.AdminRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepo;
    
    public Admin saveAdministrator()
    {
           Admin admin = new Admin();
            admin.setName(admin.getName());
            admin.setPassword("adminq");
            admin.setPassword("admin1234q");
            admin.setRole("Admiq");
            adminRepo.save(admin);
            return admin;
    }
    public List<Admin> getAllAdmin()
    {
        List<Admin> administrators = new ArrayList<>();
        adminRepo.findAll().forEach(administrators :: add);
        return administrators;
    }
    
   
    
    
    
}
