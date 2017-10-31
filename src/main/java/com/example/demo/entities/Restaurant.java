/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author User
 */
@Entity
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String restaurantName;
    private long accountId;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Category> categories ;
    private String image;
    private String address;
 

    public Restaurant() {
    }

    public Restaurant(String restaurantName, long accountId, List<Category> categories, String image, String address) {
        this.restaurantName = restaurantName;
        this.accountId = accountId;
       this.categories = categories;
        this.image = image;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Collection<Category> getCategories() {
       return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void addCategories(Category category)
     {
         if(categories == null)
         {
             categories = new ArrayList<>();
             categories.add(category);
         }
         else if( categories != null)
         {
             categories.add(category);
         }
     }  
}
