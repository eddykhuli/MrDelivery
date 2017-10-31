/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.entities.PaypalDummy;
import com.example.demo.entities.Person;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.RestaurantRequest;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.PersonService;
import com.example.demo.service.RestaurantRequestService;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService service;
    @Autowired
    private AccountRepository accRepo;
    @Autowired
    private RestaurantRequestService RestService;

    @RequestMapping(value = "/registerPerson", method = RequestMethod.POST)
    public Person register(@RequestBody Person person) {
        service.savePerson(person);
        Person existing = service.findPerson(person.getId());
        Account acc = new Account();
        if (existing != null) {
            acc.setUserId(existing.getId());
            acc.setEmail(existing.getEmail());
            acc.setPassword(existing.getPassword());
            acc.setRole("Customer");
            accRepo.save(acc);
        }

        return person;
    }

    @RequestMapping(value = "/registerPartner", method = RequestMethod.POST)
    public Person createPartnerAccount(@RequestBody RestaurantRequest restReq) {
        String[] names = restReq.getFullName().split(" ");
        String firstName = names[0]; 
        String lastName = names[1]; 
        String cellNo = restReq.getPhoneNo();
        String email = restReq.getEmail();
        String address = restReq.getLocation();
        String password = generatePwd();

        Person person = new Person();
        person.setFirstname(firstName);
        person.setSurname(lastName);
        person.setCellNo(cellNo);
        person.setEmail(email);
        person.setPassword(password);
        service.savePerson(person);
        Person existing = service.findPerson(person.getId());
        Account acc = new Account();
        if (existing != null) {
            acc.setUserId(existing.getId());
            acc.setEmail(existing.getEmail());
            acc.setPassword(existing.getPassword());
            acc.setRole("Partner");
            accRepo.save(acc);
            
        }
        
        

        return person;
    }
     @RequestMapping(value = "/registerDriverAccount", method = RequestMethod.POST)
    public Person createDriverAccount(@RequestBody RestaurantRequest restReq) {
        String[] names = restReq.getFullName().split(" ");
        String firstName = names[0]; 
        String lastName = names[1]; 
        String cellNo = restReq.getPhoneNo();
        String email = restReq.getEmail();
        String address = restReq.getLocation();
        String password = generatePwd();

        Person person = new Person();
        person.setFirstname(firstName);
        person.setSurname(lastName);
        person.setCellNo(cellNo);
        person.setEmail(email);
        person.setPassword(password);
        service.savePerson(person);
        Person existing = service.findPerson(person.getId());
        Account acc = new Account();
        if (existing != null) {
            acc.setUserId(existing.getId());
            acc.setEmail(existing.getEmail());
            acc.setPassword(existing.getPassword());
            acc.setRole("Driver");
            accRepo.save(acc);
            
        }
        
        

        return person;
    }
    
    @RequestMapping(value = "/account/person/getPerson/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson(@PathVariable("id") long id)
    {
        Person foundUser = service.findPerson(id);
        return foundUser;
    }
    
    @RequestMapping(value= "/person/deletePerson/{id}",method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable("id") long id)
    {
        service.deletePerson(id);
    }

    public String generatePwd() {

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String digits = "0123456789";
        String alphanum = upper + lower + digits;
        String pwd = "";
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            char c = alphanum.charAt(random.nextInt(alphanum.length()));
            pwd += c;
        }
        return pwd;
    }
    @RequestMapping(value="/person/getAllPeople", method = RequestMethod.GET)
    public List<Person> getAllPeople()
    {
        List<Person> people = service.getAllPeople();
        return people;
    }

   
}
