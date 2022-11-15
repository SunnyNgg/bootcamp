package com.vtxlab.Quiz2;

import java.util.ArrayList;
import java.util.List;

public class Quiz2Q16 {
  public static void main(String[] args) {
    
    List<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);
    integers.add(3);

    integers.stream().map(i -> { // do nothing,  
      System.out.println(i);
      return i +1;  //no execute
    }); 
    System.out.println(integers); //so only print the integers 1,2,3
  }
  
}
