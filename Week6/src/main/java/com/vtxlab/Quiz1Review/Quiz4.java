package com.vtxlab.Quiz1Review;

class Password2{
  private String password; 

  void ABC (String x ){
    this.password =x; 
  }

  public String getPassword(){
    return this.password; 
  }

  public void setPassword(String password){
    this.password = password; 
  }

  public void append (Password2 password){
    password.setPassword("XYZ");
    this.password = "BCD";

  }
}

public class Quiz4 {
  public static void main(String[] args) {
    Password2 p1 = new Abc("ABC");
    Password2 p2 = new ABC("BCD");
  }
 
  
}
