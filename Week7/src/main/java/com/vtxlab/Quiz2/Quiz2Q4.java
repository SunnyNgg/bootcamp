package com.vtxlab.Quiz2;

public class Quiz2Q4 {
  static byte counter = 5; //fake 
  int beCareful = 2;  //before is int 

  public static void main(String[] args) {
     Quiz2Q4 q = new Quiz2Q4();

     for( Integer i = 0; i<2; i++ ){
      counter = (byte) (i+q.beCareful);  // down case put the int in the (byte); 

     }
     System.out.println(counter);
  }
  
}
