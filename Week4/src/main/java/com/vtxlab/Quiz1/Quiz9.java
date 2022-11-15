package com.vtxlab.Quiz1;

interface Secret{
  String show();
}

class Password5 implements Secret{
  private String password; 

  @Override
  public String show(){
    System.out.println("123");
    System.out.println("***"); // no atcully implement the method because no return type of the method
    //no return keyword
  }
  Password5(String x){
    this.password = x; 
  }
}
public class Quiz9 {

  public static void main(String[] args) {
    Password5 p1 = new Password5("Start");
    p1.show();
  }
  
}
