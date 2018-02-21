/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author User
 */
@Entity
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String orderId;
     private long userId;
    private double subTotal;
    private double total;
    private String status;
    private String collectionType;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Product.class,orphanRemoval = true)
    private List<Product> cartItems =new ArrayList<>();
    private String restaurantName;
    private String orderDate;
    private String deliveryAddress;
    private String contactno;
    private String emailAddress;
    

    public OrderInfo() {
    }

    public OrderInfo(String orderId, long userId, double subTotal, double total, String status, String collectionType, String restaurantName, String orderDate, String deliveryAddress, String contactno, String emailAddress) {
        this.orderId = orderId;
        this.userId = userId;
        this.subTotal = subTotal;
        this.total = total;
        this.status = status;
        this.collectionType = collectionType;
        this.restaurantName = restaurantName;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.contactno = contactno;
        this.emailAddress = emailAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public List<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Product> cartItems) {
        this.cartItems = cartItems;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }


    public String getContactNO() {
        return contactno;
    }

    public void setContactNO(String contactNO) {
        this.contactno = contactNO;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    
   
    
    
}
