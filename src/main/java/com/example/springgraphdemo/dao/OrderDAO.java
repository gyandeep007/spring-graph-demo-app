package com.example.springgraphdemo.dao;

import com.example.springgraphdemo.businessinterface.CrudRepository;
import com.example.springgraphdemo.entity.Order;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderDAO implements CrudRepository<Order,Long> {

    @Autowired
    private EntityManager entityManager;

//    @Autowired
//    public OrderDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    public Order findById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        Order order = session.get(Order.class,id);
        session.getTransaction().commit();

        return order;
    }

    @Override
    public List<Order> findAll() {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        List<Order> orders = session.createQuery("from Order").list();
        session.getTransaction().commit();

        return orders;
    }

    @Override
    public Long save(Order order) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        long id= (int)session.save(order);
        session.getTransaction().commit();
        return id;
    }

    @Override
    public Order update(Order order) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        session.update(order);
        session.getTransaction().commit();
        return order;
    }

    @Override
    public void delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        session.beginTransaction();
        Order order = session.get(Order.class,id);
        session.remove(order);
        session.getTransaction().commit();

    }
}
