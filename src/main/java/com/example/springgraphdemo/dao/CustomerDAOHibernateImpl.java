package com.example.springgraphdemo.dao;

import com.example.springgraphdemo.businessinterface.CrudRepository;
import com.example.springgraphdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDAOHibernateImpl implements CrudRepository<Customer,Integer> {

    @Autowired
    private EntityManager entityManager;

//    @Autowired
//    public CustomerDAOHibernateImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }



    @Override
    public Customer findById(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = entityManager.find(Customer.class,id);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Customer> customerQuery = session.createQuery(" from Customer",Customer.class);

        List<Customer> customers = customerQuery.getResultList();
        session.close();
        return customers;
    }

    @Override
    public Integer save(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        int id = (int)session.save(customer);
        session.close();
        return id;
    }

    @Override
    public Customer update(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
         session.update(customer);
        return customer;
    }

    @Override
    public void delete(Integer id) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = entityManager.find(Customer.class,id);
        session.delete(customer);
        session.close();
    }
}
