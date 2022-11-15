package com.vtxlab.app;

import com.vtxlab.model.generics.Circle;
import com.vtxlab.model.generics.Customer;
import com.vtxlab.model.generics.IntegerHolder;
import com.vtxlab.model.generics.Shape;

public class Generics {

  public static void main(String[] args) {
    
    IntegerHolder inHolder = new IntegerHolder();
    inHolder.setI(101);
    System.out.println(inHolder.getI());
  

  Customer customer = new Customer<>();
  customer.setAge("123");
  System.out.println(customer.getAge().equals("123"));

  Customer <Integer> customer2 = new Customer<>();
  customer2.setAge(12);
  System.out.println(customer2.getAge());

  Customer <Double > customer3 = new Customer<>();
  customer3.setAge(12.0);
  System.out.println(customer3.getAge());

  Customer <Float > customer4 = new Customer<>();
  customer4.setAge(12.0f);
  customer4.setAge(12f);
  System.out.println(customer3.getAge());

  System.out.println(Customer.calcAge(Integer.valueOf(456)));

  System.out.println(Customer.calcAge("123"));


//Shape 
  Circle circle = new Circle();
  circle.setRadius(3);
  System.out.println(circle.area());
  System.out.println("Circle Area: " + Shape.calcArea(new Circle()));

  Shape.calcArea(new Circle(3));
  Shape.calcArea(new Circle(3));



  

  
  
}
}