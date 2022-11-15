package com.vtxlab.app;

import java.util.ArrayList;
import java.util.List;
import com.vtxlab.model.Customer;

public class HelloWorld{

  public static void main(String[] args) {
    System.out.println("Hello world ");

    Customer customer = new Customer();
    customer.setName("Sunny");
    System.out.println(customer.getName());

    List<Customer> customers = new ArrayList<>();
    customers.add(new Customer());
    customers.add(new Customer());
    
    for(Customer c : customers) {
      System.out.println(c.getName());
    }
    customers.forEach(abc -> System.out.println(abc.getName()));
  }
}