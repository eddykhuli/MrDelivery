/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Account;
import com.example.demo.entities.Restaurant;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.RestaurantRequestsRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class RestaurantService {
    
   @Autowired 
   private ProductService prodService;
   @Autowired
   private CategoryService catService;
   @Autowired
   private RestaurantRequestService restService;
   @Autowired 
   private RestaurantRepository restRepo;
   @Autowired
   private AccountService accService;
    
   public Restaurant addRestaurant(Restaurant restaurant)
   {
       
         //foundAccount.setUserId(account.getId());
         restaurant.setAccountId(restaurant.getAccountId());
         restaurant.setRestaurantName(restaurant.getRestaurantName());
         restaurant.setAddress(restaurant.getAddress());
         restaurant.setImage(restaurant.getImage());
         restRepo.save(restaurant);
         
       return restaurant;
   }
   
   public Restaurant getRestaurant(long id)
   {
       Restaurant restaurant = restRepo.findOne(id);
       return restaurant;
   }
   
   public List<Restaurant> getAllRestaurants()
   {
       List<Restaurant> restaurants = new ArrayList<>();
        restRepo.findAll().forEach(restaurants :: add);
        return restaurants;
   }
   public Restaurant getRestaurantByName(String restName)
   {
       Restaurant restaurant  = restRepo.findByRestaurantName(restName);
       return restaurant;
   }
   public Restaurant getRestaurantsByUserId(long accId)
   {
       Restaurant foundRestaurant = restRepo.findByAccountId(accId);
       return foundRestaurant;
   }
   
    
}
