package com.vtxlab.Quiz1;

import java.util.ArrayList;
import java.util.List;

public class Quiz6 {

  private String password;

  Quiz6 (String x){
    this.password = x; 
  }
  
  public static void main(String[] args) {
    int counter = 0; 
    Quiz6 p1 = new Quiz6("ABC");
    Quiz6 p2 = new Quiz6("BCD");
    List<Quiz6> passwords = new ArrayList<>();
    // do not write the passwords.add(p1);

    for(Quiz6 password : passwords){
      for(int i =0; i<2; i++){
        counter++;
      }
    }
    System.out.println(counter);
  }
}


//What is the output?
//A:8
//B:16
//C:4
//D:2
//E:0