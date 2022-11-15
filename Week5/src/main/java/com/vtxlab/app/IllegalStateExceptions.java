package com.vtxlab.app;

import java.net.StandardSocketOptions;

public class IllegalStateExceptions {
  
    public static void print (int a, int b ){
    System.out.println("Addtion of Positive Integers = " + (a+b));
    }

    public static void printAddition(int x, int y){
  
      if(x >= 0 && y >= 0){
        IllegalStateExceptions.print(x,y);
      }
      else{
        throw new IllegalStateException("Either one or two numbers are not Positive Integer");
      }
    }
    

    public static int divide (int a, int b){
      try{
        return a/b;
      }catch (ArithmeticException e){ //divided by zero
        throw new CustomException("I am throwing a CustomException");
      }
    }
    

  public static void main(String[] args) {
    try{
      printAddition(1, -100);
    }
    catch (IllegalStateException e ){
      printAddition(1, 1);
    }

    try{
      int c = divide(10, 0 );
    } catch (Exception e){
      System.out.println("I do nothing");
    }

}
}
