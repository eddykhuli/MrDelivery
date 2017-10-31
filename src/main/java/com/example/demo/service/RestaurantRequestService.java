/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.RestaurantRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.RestaurantRequestsRepository;

/**
 *
 * @author User
 */
@Service
public class RestaurantRequestService {
    
    @Autowired
    private RestaurantRequestsRepository restRepo;
    
    public void registerRestaurant(RestaurantRequest restaurant)
    {
        restRepo.save(restaurant);
    }
    public RestaurantRequest getRest(long id)
    {
        return restRepo.findOne(id);
    }
    public List<RestaurantRequest> getAllRestaurants()
    {
        
        List<RestaurantRequest> restaurants = new ArrayList<>();
        restRepo.findAll().forEach(restaurants :: add);  
        return restaurants;
    }
   
}
