// 2022 Oct 17 / Week4
package com.vtxlab.LessonWeekFour;

import java.util.Scanner;

interface MathOperation {
  int compute(int a, int b);

  default void SayHello(){
    System.out.println("hello");
}
}

class MathOperationTester{


  private static int calculate(int a, int b, MathOperation op){
    return op.compute(a,b);
  }


  public static void main(String[] args) {
    //No Lambda 

    MathOperation addMathOperation = new MathOperation() {
      @Override
      public int compute (int a, int b){
        return a+b;
      }
    };
 

    //Lambda
    Scanner input = new Scanner(System.in);
    System.out.println("input x : ");
    int input1 = input.nextInt();
    System.out.println("input y : ");
    int input2 = input.nextInt();

    MathOperation subtraction = (int a, int b) -> a - b;

    MathOperation addition = (a,b) -> a + b;

    MathOperation multiplication = (a , b) -> a * b;

    //Lambda expression passed in as a method argument
    System.out.println("12 + 4 = " + calculate(12, 4, addition) );
    System.out.println("12 - 4 = " + calculate(12, 4, subtraction) );
    System.out.println("12 * 4 = " + calculate(12, 4, multiplication) );

    //Lambda expreession without a refernce variable
    System.out.println("12 / 4 = " + calculate(12, 4, (a, b) -> a/b));

    System.out.println("The addtional is = " + addition.compute(input1,input2));

  }

  
}

