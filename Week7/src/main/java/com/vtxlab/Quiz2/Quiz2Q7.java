package com.vtxlab.Quiz2;
interface Superman{
  void protect(Children child); // Funtional interface Consumer 
}

interface Children{
  void cry();
}

public class Quiz2Q7 {
  public static void main(String[] args) {
    Superman s = x -> x.cry(); // providing implementation ONLY , No any execute anything, (protect method will excute the cry )
    s.protect( () -> System.out.println("Yes, I am crying")); // protect() method actually is the cry method; 
  }
  
}
