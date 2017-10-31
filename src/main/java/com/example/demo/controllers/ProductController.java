/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(path = "/api/product/")
@Api(value = "ProductControllerApi" , produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    
   @Autowired
   private ProductService prodService;
  
    
   @RequestMapping(value = "/restaurant/addProduct/{categoryName}", method = RequestMethod.POST)
   public Category addNewProduct(@PathVariable @Valid String categoryName,@RequestBody @Valid Product product)
   {
       Category updatedCategory = prodService.AddProduct(categoryName,product);
       
       return updatedCategory;
   }
   
   @RequestMapping(value = "/restaurant/deleteProduct/{id}" , method = RequestMethod.POST)
   public String deleteProduct(@PathVariable long id)
   {
       return prodService.deleteProduct(id);
   }
   
   @RequestMapping(value = "/restaurant/getAllProducts/" , method = RequestMethod.GET)
   public List<Product> getAllProducts()
   {
       List<Product> products = prodService.getAllProducts();
       
       return products;
   }
   @RequestMapping(value = "/restaurant/getAllProductsByCategoryName/{categoryName}" , method = RequestMethod.GET)
   public List<Product> getAllProductsByCategory(@PathVariable @Valid String categoryName)
   {
       List<Product> products = prodService.getByCategoryName(categoryName);
       
       return products;
   }
}
