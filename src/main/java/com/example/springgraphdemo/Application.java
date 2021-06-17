package com.example.springgraphdemo;

import com.example.springgraphdemo.businessinterface.CrudRepository;
import com.example.springgraphdemo.dao.CustomerDAOHibernateImpl;
import com.example.springgraphdemo.entity.Customer;
import com.example.springgraphdemo.resolver.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringGraphDemoApplication.class);
       // Query query = context.getBean(Query.class);

     //   System.out.println(query==null?"not found":"found");
    }
}
