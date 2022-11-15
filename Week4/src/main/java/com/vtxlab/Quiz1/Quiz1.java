package com.vtxlab.Quiz1;

class Password{
  private String password;

  Password(String x){
    this.password = x;
  }
}


public class Quiz1 {

  public static void main(String[] args){
    Password p1 = new Password("ABC");
    Password p2 = new Password("ABC");
    Password p3 = new Password("BCD");
    String s1 = new String("abc");

    System.out.println(p1 == p2);
    System.out.println(p2 == p3);
    System.out.println(p1. equals(p2));
    System.out.println("abc".equals(s1));


  }
}

//What is the output 
// A:true,false,true,true
// B:false,false,false,true
// C:false,false,true,true
// D:true,false,true,false
// E:false,false,false,false
