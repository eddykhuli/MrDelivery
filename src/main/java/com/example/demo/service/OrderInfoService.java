/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.OrderInfo;
import com.example.demo.entities.Product;
import com.example.demo.repository.OrderInfoRepository;
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
public class OrderInfoService {
 
    @Autowired
    private OrderInfoRepository orderRepo;
    
    @Autowired
    private ProductRepository prodCategory;
            
    public OrderInfo addOrder(OrderInfo order)
    {
        OrderInfo toOrder = new OrderInfo();
        List<Product> products = new ArrayList<>();
        
        //toOrder.setId(order.getId());
        toOrder.setOrderId(order.getOrderId());
        toOrder.setUserId(order.getUserId());
        toOrder.setCollectionType(order.getCollectionType());
        toOrder.setTotal(order.getTotal());
        toOrder.setSubTotal(order.getSubTotal());
        
        for(int x =0 ; x < order.getCartItems().size() ;x++)
        {
            long id = order.getCartItems().get(x).getId();
            
            Product product = prodCategory.findOne(id);
            products.add(product);
            
        }
        toOrder.setCartItems(products);
        toOrder.setStatus(order.getStatus());
        toOrder.setRestaurantName(order.getRestaurantName());
        toOrder.setOrderDate(order.getOrderDate());
        orderRepo.save(toOrder);
        toOrder.setDeliveryAddress(order.getDeliveryAddress());
        toOrder.setContactNO(order.getContactNO());
        toOrder.setEmailAddress(order.getEmailAddress());

        return order;
    }
    public OrderInfo getUserOrder(long userId)
    {
        OrderInfo foundOrder = orderRepo.findByUserId(userId);
        return foundOrder;
    }
    public List<OrderInfo> getAllCustomerOrders(long userId)
    {
        List<OrderInfo> customerOrders = new ArrayList<>();
        orderRepo.findAllByUserId(userId).forEach(customerOrders :: add);
        return customerOrders;
    }
    public List<OrderInfo> getAllOrders()
    {
         List<OrderInfo> customerOrders = new ArrayList<>();
        orderRepo.findAll().forEach(customerOrders :: add);
        return customerOrders;
    }
    public OrderInfo updateOrder(String orderId,OrderInfo order)
    {
        OrderInfo updatedOrder = orderRepo.findByOrderId(orderId);
        updatedOrder.setStatus(order.getStatus());
        orderRepo.save(updatedOrder);
        return updatedOrder;
    }
    public List<OrderInfo> getOrdersByRestName(String restaurantName)
    {
            List<OrderInfo> matchingOrders = new ArrayList<>();
            orderRepo.findByRestaurantName(restaurantName).forEach(matchingOrders :: add);
            return matchingOrders;
    }
    public List<OrderInfo> finndOrderToDeliver(String status)
    {
        List<OrderInfo> toDeliverOrders = new ArrayList<>();
        orderRepo.findByStatus(status).forEach(toDeliverOrders :: add);
        return toDeliverOrders;
    }
    
   
}
