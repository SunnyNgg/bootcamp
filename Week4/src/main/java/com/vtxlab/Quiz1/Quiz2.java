package com.vtxlab.Quiz1;

class Password1{
  public static int counter = 2;
  private String password;

  Password1(String x){
    this.password = x;
    counter++;
  }

  public void setPassword(String password){
    this.password = password;
    counter--;
  }
}

public class Quiz2 {
  public static void main(String[] args){
    Password1 p1 = new Password1("ABC");
    Password1 p2 = new Password1("ABC");
    Password1 p3 = new Password1("BCD");
    p2.setPassword("password");
    p2.setPassword("2");
    Password1.counter *= Password1.counter;

    System.out.println(Password1.counter);

  }
}
// What is the output 
// A:3
// B:4
// C:9
// D:16
// E:12
