package com.vtxlab.model.customer;

import java.time.LocalDate;

public class Person<T> {

  int age; 
  String name; 
  T birthday; 

  Person(){}
  
  Person(int age, String name, T birthday){
    this.age= age;
    this.name = name; 
    this.birthday = birthday;

  }


    public void setAge(int age){
      this.age =age; 
    }

    public int getAge(){
      return age; 
    }

    public void  setBrithday(T birthday){
      this.birthday = birthday;
    }

    public T getBrithday(){
      return birthday;
    }

    public void setName(String name){
      this.name = name; 
    }

    public String getName(){
      return name; 
    }

    public static void main(String[] args) {
      Person<Integer>person = new Person<>(23, "Sunny", 123);
      person.setAge(123);
      person.setBrithday(23);
      System.out.println(person.getAge());
      System.out.println(person.getBrithday());
      System.out.println(person.getName());
      
    }

  
}
