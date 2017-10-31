/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entities.Person;
import com.example.demo.repository.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepo;
    
    public Person savePerson(Person person)
    {
        return personRepo.save(person);
    }
    
    public Person findPerson(long id)
    {
        return personRepo.findOne(id);
    }
         
    public Person updateCustomer(long id,Person person)
    {
        Person updatedPerson = personRepo.findOne(id);
        updatedPerson.setFirstname(person.getFirstname());
        updatedPerson.setSurname(person.getSurname());
        updatedPerson.setCellNo(person.getCellNo());
        updatedPerson.setEmail(person.getEmail());
        updatedPerson.setAddress(person.getAddress());
        updatedPerson.setPassword(person.getPassword());
        
        personRepo.save(person);
        return person;
    }
    
    public void deletePerson(long id)
    {
        Person foundPerson = personRepo.findOne(id);
        personRepo.delete(foundPerson.getId());
        
    }
    
    public List<Person> getAllPeople()
    {
        List<Person> people = new ArrayList<>();
        personRepo.findAll().forEach(people :: add);
        return people;
    }
    
   
    
    
    
    
    
    
}
