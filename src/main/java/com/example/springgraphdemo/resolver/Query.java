package com.example.springgraphdemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.springgraphdemo.businessinterface.CrudRepository;
import com.example.springgraphdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public class Query implements GraphQLQueryResolver {

    @Autowired
    private CrudRepository<Customer,Integer> customerDAO;

    public Query(CrudRepository<Customer,Integer>  customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Iterable<Customer> findAllCustomers(){
        return customerDAO.findAll();
    }

    public Customer findOrderByCustomer(int customerId){
        return customerDAO.findById(customerId);
    }

}
