package com.vtxlab.model.generics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Customer<T> {
  
  private T age; 

  public T getAge(){
    return this.age;
  }

  public void setAge(T age){
    this.age = age;
  }

  public static <T extends Object>T calcAge( T a) {
    return a ;
  }

  public static <T extends Number> T calcAge2(Customer <T> a){
    return a.getAge();
  }



}
