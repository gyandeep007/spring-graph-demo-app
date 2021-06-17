package com.example.springgraphdemo.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_first_name")
    private String customerFirstName;
    @Column(name = "customer_last_name")
    private String customerLastName;
    @Column(name = "customer_address")
    private String customer_address;
    @Column(name = "customer_city")
    private String customerCity;
    @Column(name = "customer_state")
    private String customerState;
    @Column(name = "customer_zip")
    private String customerZip;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "customer_fax")
    private String customerFax;
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "hasCustomer",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,
            CascadeType.REFRESH},fetch = FetchType.EAGER)
    public List<Order> hasOrder;

    public Customer() {
    }

    public Customer(String customerFirstName, String customerLastName, String customer_address, String customerCity, String customerState, String customerZip, String customerPhone, String customerFax, String status) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customer_address = customer_address;
        this.customerCity = customerCity;
        this.customerState = customerState;
        this.customerZip = customerZip;
        this.customerPhone = customerPhone;
        this.customerFax = customerFax;
        this.status = status;
    }

    public List<Order> getHasOrder() {
        return hasOrder;
    }

    public void setHasOrder(List<Order> hasOrder) {
        this.hasOrder = hasOrder;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerFax() {
        return customerFax;
    }

    public void setCustomerFax(String customerFax) {
        this.customerFax = customerFax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customer_address='" + customer_address + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerState='" + customerState + '\'' +
                ", customerZip='" + customerZip + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerFax='" + customerFax + '\'' +
                ", status='" + status + '\'' +
            //    ", hasOrder=" + hasOrder +
                '}';
    }
}
