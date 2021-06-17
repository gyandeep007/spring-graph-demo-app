package com.example.springgraphdemo;

import com.coxautodev.graphql.tools.SchemaParser;
import com.example.springgraphdemo.businessinterface.CrudRepository;
import com.example.springgraphdemo.entity.Customer;
import com.example.springgraphdemo.resolver.Query;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.ExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLServlet;
import graphql.servlet.SimpleGraphQLServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import java.util.List;

@SpringBootApplication
public class SpringGraphDemoApplication {

    public static void main(String[] args) {
      ApplicationContext context= SpringApplication.run(SpringGraphDemoApplication.class, args);

        Query query = context.getBean(Query.class);
       Iterable<Customer> customer= query.findAllCustomers();
       //        System.out.println(customer);
    }

    @Autowired
    CrudRepository<Customer,Integer>  customerDAO;
    @Bean
    public Query query(CrudRepository<Customer,Integer>  customerDAO) {
        return new Query(customerDAO);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {

        GraphQLSchema schema  = SchemaParser.newParser()
                .resolvers(query(customerDAO))
                .file("graphql/customers.graphqls")
               .build().makeExecutableSchema();
        ExecutionStrategy executionStrategy = new AsyncExecutionStrategy();
        GraphQLServlet servlet = new SimpleGraphQLServlet(schema, executionStrategy);
        ServletRegistrationBean bean = new ServletRegistrationBean(servlet, "/graphql");
        return bean;
    }

}
