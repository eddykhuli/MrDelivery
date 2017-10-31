/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.Restaurant;
import com.example.demo.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private RestaurantService restService;
    
    public Restaurant addCategory(Category category,long accountId) 
    {
        Restaurant restaurant = restService.getRestaurant(accountId);
        restaurant.addCategories(category);
        catRepo.save(category);
        restService.addRestaurant(restaurant);

        return restaurant;
    }

    public List<Category> getAllCategories() 
    {
        List<Category> categories = new ArrayList<>();
        catRepo.findAll().forEach(categories::add);
        return categories;
    }
    
    public Category getCategory(long id)
    {
       Category category = catRepo.findOne(id);
       return category;
    }
    public List<Category> getByRestID(long restId)
    {
        List<Category> foundCategory = catRepo.findByRestId(restId);
        return foundCategory;
    }
    public Category getCategoryByName(String name)
    {
        Category category = catRepo.findByCategoryName(name);
        return category;
    }
    
    public void removeCategory(long id)
    {
        catRepo.delete(id);
    }

}
