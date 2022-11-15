package com.vtxlab.Quiz1;

class Password3{
  private String password;

  static String concat(String x){
    return x; 
  }

  Password3(String x){
    this.password = x;
  }

  String concat(String x, String y){
    return y.toLowerCase().toUpperCase();

  }
}
public class Quiz7 {
  public static void main(String[] args){
    int counter =0;
    Password3 p1 = new Password3("Start");
    System.out.println(p1.concat("XYZ", "abc")); // 6-7 line is fake
  } //only see the 14-15line method, that only return y "abc" toLowerCase() then toUpperCase()
   // so the answers is "ABC"
}

//What is the output?
//A:Start abc
//B:abc 
//C:ABC
//D:XTZ
//E:XYZabc
