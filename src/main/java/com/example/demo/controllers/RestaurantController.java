/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.entities.Restaurant;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.RestaurantService;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(path = "/api/restaurant/")
@Api(value = "RestaurantControllerApi" , produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    
    @Autowired
    private RestaurantService restService;
    @Autowired 
    private CategoryService catService;
    @Autowired 
    private AccountRepository accRepo;
    
    
    @RequestMapping(value = "/restaurant/addRestaurant" , method = RequestMethod.POST)
    public Restaurant addRestaurant(@RequestBody @Valid Restaurant restaurant)
    {

         restService.addRestaurant(restaurant);
        
        return restaurant;
    }
    
    @RequestMapping(value = "/restaurant/getAllRestaurants" , method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants()
    {
        List<Restaurant> restaurants = restService.getAllRestaurants();
        return restaurants;
        
    }
   
     @RequestMapping(value = "/restaurant/getOnerestaurant/{accId}", method = RequestMethod.GET)
    public Restaurant getRestaurant(@PathVariable @Valid long accId)
    {
        Restaurant restaurant = restService.getRestaurant(accId);
        return restaurant;
    }
    
    @RequestMapping(value = "/restaurant/getByAccountId/{accId}" , method = RequestMethod.GET)
    public Restaurant getRestByAccountId(@PathVariable @Valid long accId)
    {
        Restaurant restaurant = restService.getRestaurantsByUserId(accId);
        return restaurant;
    }
    
    
    
}
