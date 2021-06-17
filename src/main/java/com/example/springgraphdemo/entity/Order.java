package com.example.springgraphdemo.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "item_id")
    @SequenceGenerator(name = "item_id",sequenceName = "order_seq",allocationSize = 1)
    @Column(name = "ORDER_ID")
    private int orderId;

//    @Column(name = "CUSTOMER_ID")
//    private int customerId;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "SHIPPED_DATE")
    private Date shippedDate;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "CUSTOMER_ID")
    public Customer hasCustomer;

    public Order() {
    }

    public Order( Date orderDate, Date shippedDate) {
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
    }

    public Customer getHasCustomer() {
        return hasCustomer;
    }

    public void setHasCustomer(Customer hasCustomer) {
        this.hasCustomer = hasCustomer;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippedDate() {
        return this.shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", shippedDate=" + shippedDate +
                ", Customer Detail=" + hasCustomer +
                '}';
    }
}
