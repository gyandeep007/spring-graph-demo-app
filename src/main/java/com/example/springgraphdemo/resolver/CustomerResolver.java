package com.example.springgraphdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.springgraphdemo.businessinterface.CrudRepository;
import com.example.springgraphdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerResolver implements GraphQLResolver<Customer>    {
    private CrudRepository<Customer,Integer> customerDAO;

    @Autowired
    public CustomerResolver(CrudRepository<Customer,Integer> customerDAO) {
        this.customerDAO = customerDAO;
    }
}
