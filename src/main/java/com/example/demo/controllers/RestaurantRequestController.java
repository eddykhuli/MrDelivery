/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.RestaurantRequest;
import com.example.demo.service.RestaurantRequestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.RestaurantRequestsRepository;

/**
 *
 * @author User
 */
@RestController
public class RestaurantRequestController {
    
    @Autowired
    private RestaurantRequestService restService;
    
    @Autowired
    private RestaurantRequestsRepository repo;
    
    @RequestMapping(value = "/placeRequestForRestaurant" , method = RequestMethod.POST)
    public void registerRestaurant(@RequestBody RestaurantRequest restaurant)
    {
        restService.registerRestaurant(restaurant);
    }
    
    @RequestMapping(value = "/getAllRestaurantsRequests")
    public List<RestaurantRequest> getAllRestaurants()
    {
        return restService.getAllRestaurants();
    }
    
    @RequestMapping(value = "/removeRequest", method = RequestMethod.POST)
    public void Remove(@RequestBody RestaurantRequest rest)
    {
        repo.delete(rest);
    }
    @RequestMapping(value= "/getRestaurantRequest", method = RequestMethod.POST)
    public RestaurantRequest getRestaurant(long id)
    {
        return restService.getRest(id);
    }
    
}
