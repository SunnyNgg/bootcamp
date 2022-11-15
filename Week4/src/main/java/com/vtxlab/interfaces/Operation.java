package com.vtxlab.interfaces;



public class Operation {

  @FunctionalInterface
public interface MathOperation {

  int compute (int x, int y);


default void SayHello(){
  System.out.println("hello");
}

  private static int calculate(int a, int b, MathOperation op){
  return op.compute(a,b);
  
}
}


}