package com.vtxlab.Quiz2;

import java.util.LinkedList;

public class Quiz2Q5 {
  public static void main(String[] args) {
    LinkedList<String> strings = new LinkedList<>();

    for(int i = 0; i<4; i++){
      if(i % 2 > 0){  
        strings.addLast("N"); // if odd add "N"
      }else{
        strings.addLast("C"); // if even add "C"
      }
    }
    strings.addFirst("V"); //VCNCN
    strings.add("T"); // VCNCT
    strings.add(4,"E"); //insert VCNCENT
    strings.set(2, "I"); //repay the (N)  //VCICENT
    System.out.println(strings);
  }
  
}
