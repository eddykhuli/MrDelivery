/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entities.Restaurant;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface RestaurantRepository extends CrudRepository<Restaurant , Long> {
    public Restaurant findByRestaurantName(String name);
    public Restaurant findByAccountId(long accId);
    public List<Restaurant> findByAddress(String address);
}
