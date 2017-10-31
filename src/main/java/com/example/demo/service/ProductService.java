/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository prodRepo;
    @Autowired
    private CategoryService catService;
    @Autowired
    private RestaurantService restService;
    
    @Autowired
    private CategoryRepository categoryRepo;
    
    public Category AddProduct(String category,Product product)
    {
            prodRepo.save(product);
           Category categoryObj = catService.getCategoryByName(category);
           categoryObj.addProducts(product);
           Category UpdatedCategory =  categoryRepo.save(categoryObj);
                   
        return UpdatedCategory;
    }
    public String deleteProduct(long id)
    {
        prodRepo.delete(id);
        return "Deleted";
    }
    public List<Product> getAllProducts()
    {
        List<Product> products = new ArrayList<>();
         prodRepo.findAll().forEach(products :: add);
      
        return products;
    }
    public Product getProduct(long id)
    {
        Product product = prodRepo.findOne(id);
        return product;
    }
    public List<Product> getByCategoryName(String category)
    {
       List<Product> matchingProducts  = new ArrayList<>();
       prodRepo.getByCategory(category).forEach(matchingProducts :: add);
       return matchingProducts;
    }
}
