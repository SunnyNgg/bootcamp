package com.vtxlab.model.generics;

public abstract class Shape {

  public String color;


  public static <T extends Shape & Area> double calcArea(T t){
    return t.area();

  }

  public static double calArea2(Area s){
    return s.area();
  }
  
}
