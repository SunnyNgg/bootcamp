package com.vtxlab.app;

class IaeDemo {
  public static void print(int a )
  {
    if( a >= 18 )
    {
      System.out.println("Eligible for Voting");
    }
    else
    {
      
    }
  }
}

public class Exception {
  public static void main(String[] args) {
    
    int i = 0 ;
    int y = 2 ; 
    try{
      y=y / i;
    }catch (ArithmeticException e ){
      y= 0; 
      
    }
    System.out.println(y);
  }
  
}
