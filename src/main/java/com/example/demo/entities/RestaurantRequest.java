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
public class RestaurantRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "Full_Names")
    private String fullName;
    @Column(name = "Phone_Number")
    private String phoneNo;
    @Column(name = "Email_Address")
    private String email;
    @Column(name = "Location")
    private String location;
    @Column(name = "Restaurant_Name")
    private String restaurantName;
    @Column(name = "Description")
    private String description;
    @Column(name = "About_Shop")
    private String additionalInfo;

    public RestaurantRequest() {
    }

    public RestaurantRequest(String fullName, String phoneNo, String email, String location, String restaurantName, String description, String additionalInfo) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.location = location;
        this.restaurantName = restaurantName;
        this.description = description;
        this.additionalInfo = additionalInfo;
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

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    
   
}
