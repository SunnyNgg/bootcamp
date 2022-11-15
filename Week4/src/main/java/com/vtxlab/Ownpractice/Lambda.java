package com.vtxlab.Ownpractice;

import java.util.Scanner;

interface Area{
  int compute(int base, int hight);

}

 class Shape {
  private static int calculate(int base, int hight, Area op){
    return op.compute(base, hight);

  }



    public static void main(String[] args) {

      Area triangleArea  = (base, hight) -> (base * hight) / 2;

      Area rectangleArea =  (base, hight) -> base * hight;  

      Scanner input = new Scanner(System.in);
      System.out.println("Base :");
      int input1 = input.nextInt();

      System.out.println("Hight :");
      int input2 = input.nextInt();

      System.out.println("The Triangle Arae is " + triangleArea.compute(input1,input2) );
      System.out.println("The Rectangle Arae is " + rectangleArea.compute(input1,input2) );



      
    }
  }

