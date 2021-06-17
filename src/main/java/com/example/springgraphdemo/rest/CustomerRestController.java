package com.example.springgraphdemo.rest;


import com.example.springgraphdemo.businessinterface.CrudRepository;
import com.example.springgraphdemo.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CrudRepository<Customer,Integer> customerDAO;



    @Autowired
    public CustomerRestController(CrudRepository<Customer,Integer> customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/customers")
    public List<Customer> findAll(){
        return customerDAO.findAll();
    }
}
