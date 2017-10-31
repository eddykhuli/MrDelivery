/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entities.Category;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository 
public interface CategoryRepository extends CrudRepository<Category, Long>{
    
    public Category findByCategoryName(String name);
    public List<Category> findByRestId(long restId);
    
}
