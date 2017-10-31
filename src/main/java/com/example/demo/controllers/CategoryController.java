/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Category;
import com.example.demo.entities.Restaurant;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.RestaurantService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class CategoryController {
    
    @Autowired
    private CategoryService catService;
    @Autowired
    private RestaurantService restService;
    @Autowired 
    CategoryRepository catRepo;
  @RequestMapping(value = "/categories/addCategory/{accId}" , method = RequestMethod.POST)
   public Restaurant addCategory(@PathVariable @Valid long accId,@RequestBody @Valid Category category)
   {
           Restaurant updateRestaurant = restService.getRestaurant(accId);
           updateRestaurant.addCategories(category);
           catRepo.save(category);
           restService.addRestaurant(updateRestaurant);
       
       return updateRestaurant;
   }
   //
   @RequestMapping(value = "/categories/getCategory/{id}" , method = RequestMethod.GET)
   public Category getCategory(@PathVariable long id)
   {
       Category category = catService.getCategory(id);
       return category;
   }
   @RequestMapping(value="/categories/getAllCategories" , method = RequestMethod.GET)
   public List<Category> getCategories()
   {
       List<Category> categories = catService.getAllCategories();
       
       return categories;
   }
   @RequestMapping(value = "/categories/get/getCategoryByName/{categoryName}" ,  method = RequestMethod.GET)
   public Category getCategoryByName(@PathVariable @Valid String categoryName)
   {
       Category foundCategory = catService.getCategoryByName(categoryName);
       return foundCategory;
   }
    
   @RequestMapping(value = "/categories/get/getCategoryByRestId/{restId}" , method = RequestMethod.GET)
   public List<Category> getByRestaurantId(@PathVariable @Valid long restId)
   {
       List<Category> foundCategory = catService.getByRestID(restId);
       return foundCategory;
   }
    
}
