/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entities.OrderInfo;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface OrderInfoRepository extends CrudRepository<OrderInfo, String>{
 public List<OrderInfo> findAllByUserId(long userId);  
 public OrderInfo findByUserId(long userId);
 public OrderInfo findByOrderId(String orderId);
 public List<OrderInfo> findByRestaurantName(String restaurantName);
 public List<OrderInfo>  findByStatus(String status);
}
