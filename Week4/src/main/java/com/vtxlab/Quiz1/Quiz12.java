package com.vtxlab.Quiz1;

public class Quiz12 {
  public static long fibonacci(long number){
    if(number == 0 || number == 1){
      return number;
    }
    return fibonacci(number-1) + fibonacci(number -2 );
  }

  public static void main(String[] args) {
    System.out.println(Quiz12.fibonacci(4));
  }
  //4
    // 4-1 ->2
        //3-1 ->1
            //2-1 -> return 1
             //2-2 -> return 0
      // 3-2 -> return 1 
    // 4-2 -> 1 
      // 2-1 -> return 1
      // 2-2 -> return 0 

      //total 1+1+1 = 3 
}
