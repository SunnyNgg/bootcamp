package com.vtxlab.Ownpractice;

import java.util.ArrayList;
import java.util.function.Consumer;



public class Lambda2 {

  public static void main(String[] args) {
    //use a lambda expressions in the Arraylist's forEach()
    ArrayList<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(4);
    list1.add(5);

    list1.forEach(e -> 
      System.out.println(e)
    );

    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(1);
    list2.add(3);
    list2.add(5);
    list2.add(7);
    list2.add(9);

    Consumer<Integer> method = (n) -> {System.out.println(n);};
    list2.forEach(method);

  
  
}
}
