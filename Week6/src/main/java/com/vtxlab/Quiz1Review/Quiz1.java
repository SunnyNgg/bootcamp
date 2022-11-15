package com.vtxlab.Quiz1Review;

class Password{
  private String password; 

  Password(String x ){
    this.password = x ; 
  }
}

public class Quiz1 {
  public static void main(String[] args) {
    Password p1 = new Password("ABC");
    Password p2 = new Password("ABC");
    Password p3 = new Password("ABC");
    String s1 = new String("abc");

    System.out.println(p1 == p2);
    System.out.println(p2 == p3);
    System.out.println(p1.equals(p2));
    System.out.println("abc".equals(s1));

  }
}
