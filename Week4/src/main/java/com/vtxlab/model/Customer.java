package com.vtxlab.model;

public class Customer {
  private String name; // package-private
  private String idNumber;
  private int age;

  public Customer (){}
  Customer (String name){
    this.name = name;
    this.idNumber =idNumber;
    this.age = age;

  }

  public String getName(){
  return this.name;
  }

  public void setName(String name){
    this.name = name; 

  }
}
