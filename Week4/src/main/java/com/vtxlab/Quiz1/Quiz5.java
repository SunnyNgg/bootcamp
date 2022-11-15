package com.vtxlab.Quiz1;

public class Quiz5 {

  private String password;

  Quiz5(String x){
    this.password =x;

  }
  public String getPassword(){
    return this.password;
  }

  public void setPassword(String password){
    this.password = password;
  }

  public static void main(String[] args) {
    Quiz5 p1 = new Quiz5("ABC");
    Quiz5 p2 = new Quiz5("BCD");

    if( p1 == p2 || !p1.equals(p2)){
      p1 = p2;
    } 
     else if (!p1.equals(p2)){
      p2 = p1;
     }
     else {
      p1.setPassword("null");
      p2.setPassword("null");
     }
     System.out.println(p1.getPassword() + p2.getPassword());
  }
  
}

//What is the output?
//A: BCDBCD
//B: ABCBCD
//C: nullnull
//D: ABCABC
//E: ABCnull