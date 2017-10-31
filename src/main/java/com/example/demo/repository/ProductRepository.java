/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entities.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface ProductRepository extends CrudRepository<Product, Long >{
    public List<Product> getByCategory(String categoryName);
}
