/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.OrderInfo;
import com.example.demo.service.OrderInfoService;
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
public class OrderInfoController {
    
    @Autowired
    private OrderInfoService orderService;
    
    
    
    @RequestMapping(value = "/order/saveOrder", method = RequestMethod.POST)
    public OrderInfo saveOrder(@RequestBody @Valid OrderInfo order)
    {
        orderService.addOrder(order);
        return order;
    }
    
    @RequestMapping(value = "/login/customer/viewOrders/{userId}",method = RequestMethod.GET)
    public List<OrderInfo> getAllOrders(@PathVariable @Valid long userId)
    {
        List<OrderInfo> orders = orderService.getAllCustomerOrders(userId);
        return orders;
    }
    
    @RequestMapping(value = "/restaurant/getOrders/{restaurantName}", method = RequestMethod.GET)
    public List<OrderInfo> getRestarantOrders(@PathVariable @Valid String restaurantName)
    {
        List<OrderInfo> restaurantOrders = orderService.getOrdersByRestName(restaurantName);
        return restaurantOrders;
    }
    
    @RequestMapping(value = "/restaurant/order/updateOrder/{orderId}", method = RequestMethod.PUT)
    public OrderInfo updateOrderStatus(@PathVariable @Valid String orderId,@RequestBody @Valid OrderInfo order)
    {
        OrderInfo updatedOrder = orderService.updateOrder(orderId, order);
        return updatedOrder;
    }
    @RequestMapping(value = "/driver/order/findByStatus/{status}", method = RequestMethod.GET)
    public List<OrderInfo> getByStatus(@PathVariable @Valid String status)
    {
        List<OrderInfo> toDeliverOrders = orderService.finndOrderToDeliver(status);
        return toDeliverOrders;
    }
    @RequestMapping(value = "/admin/order/allOrders" , method = RequestMethod.GET)
    public List<OrderInfo> AdminGetAllOrders()
    {
        List<OrderInfo> allOrders = orderService.getAllOrders();
        return allOrders;
    }
}
