/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.controllers.AccountController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */
@Controller
public class XController {
    
    @RequestMapping("/")
    public String index(){
      
        return "index";
    }
    
    @RequestMapping("/register")
    public String register(){
        return "reqister";
    }
    
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
   
    @RequestMapping("/registerRestaurant")
    public String registerRestaurant()
    {
        return "registerRestaurant";
    }
    @RequestMapping("/registerDriver")
    public String registerDriver()
    {
        return "registerDriver";
    }
    
    @RequestMapping("/login/customer")
    public String rests()
    {
        return "welcome_user";
    }
    @RequestMapping("/login/admin")
    public String admin()
    {
        return "admin";
    }
    @RequestMapping("/customer/viewProfile")
    public String viewProfile()
    {
        return "viewProfile";
    }
    @RequestMapping("/updateProfile")
    public String updateProfile()
    {
        return "updateProfile";
    }
    @RequestMapping("/admin/customers")
    public String getAllCustomers()
    {
        return "customers";
    }
    @RequestMapping("/login/restaurant")
    public String restaurantPortal()
    {
        return "restaurantPortal";
    }
    
    @RequestMapping("/login/customer/restaurants")
    public String restaurants()
    {
        return "restaurantsPage";
    }
    @RequestMapping("/restaurants/menu")
    public String restaurantMenu()
    {
        return "restaurantMenuPage";
    }
    @RequestMapping("/customer/menu/addToCart")
    public String addToCart()
    {
        return "cart";
    }
    @RequestMapping("/login/customer/orders")
    public String viewOrders()
    {
        return "ordersPage";
    }
    @RequestMapping("/order/payment/cashPayment")
    public String cashPayment()
    {
        return "cashPayment";
    }
    @RequestMapping("/order/payment/cardPayment")
    public String cardpayment()
    {
        return "cardPayment";
    }
    @RequestMapping("/home/terms")
    public String termsAndconditions()
    {
        return "terms";
    }
    @RequestMapping("/home/faqs")
    public String faqs()
    {
        return "FAQ";
    }
    @RequestMapping("login/driver")
    public String driverLogin()
    {
        return "driver";    }
}
