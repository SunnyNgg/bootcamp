package com.vtxlab.Quiz1Review;

class Password1{
  public static int counter = 2; 
  private String password; 

  Password1(String x){
    this.password = x;
    counter++; 
  }

  public void setPassword1 (String password){
    this.password = password;
    counter--;
  }
}

public class Quiz2 {
  public static void main(String[] args) {
    Password1 p1 = new Password1("ABC");
    Password1 p2 = new Password1("ABC");
    Password1 p3 = new Password1("BCD");
    p2.setPassword1("abc");
    Password1.counter *= Password1.counter;

    System.out.println(Password1.counter);
  }
  
}
