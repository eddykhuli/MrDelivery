/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author User
 */
@Entity
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column( name = "Full_Names")
    private String fullName;
    @Column( name = "Phone_No")
    private String phoneNo;
    @Column( name = "Email")
    private String email;
    @Column( name = "Location")
    private String location;
    @Column( name = "transport")
    private String transport;
    @Column( name = "Drivers_license")
    private String license;
    private String appoint;
    @Column( name = "Available_Time")
    private String availability;

    public Driver() {
    }

    public Driver(String fullName, String phoneNo, String email, String location, String transport, String license, String availability) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.location = location;
        this.transport = transport;
        this.license = license;
        this.availability = availability;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    
}
