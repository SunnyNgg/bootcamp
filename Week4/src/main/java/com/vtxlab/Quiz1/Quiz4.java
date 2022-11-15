package com.vtxlab.Quiz1;

class Password2{
  private String password;

  Password2(String x){
    this.password = x;
  }
  public String getPassword(){
    return this.password;
  }

  public void setPassword(String password){
    this.password = password;
  }

  public void append(Password2 password){
    password.setPassword(("XYZ"));
    this.password ="BCD";
  }
}

public class Quiz4 {
  public static void main(String[] args){
    Password2 p1 = new Password2("XYZ");
    Password2 p2 = new Password2("XYZ");
    p1.append(p2); //P1 = XYZ / P2=BCD  so XYZ=BCD // so P1 = BCD
    System.out.println(p1.getPassword() + p2.getPassword()); //BCDXYZ
    
    }
}

//what is the output?
// A:BCDXYZ
// B:ABCBCD
// C:ABCXYZ
// D:BCDBCD
// F:ABCABC
