package com.vtxlab.Quiz1Review;

public class Quiz3 {

  static int counter = 10; 

  public static void main(String args[]) {

    for(byte i =0; i < 128; i--){
      counter++;
    }
    System.out.println(counter);
  }
  
}
//A: 127
//B: 137
//C: 139
//D: infiinte loop 
//E: 126