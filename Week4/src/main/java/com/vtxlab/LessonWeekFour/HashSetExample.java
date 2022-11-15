package com.vtxlab.LessonWeekFour;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetExample {

  public static void main(String[] args) {
    
  
  Set<Integer> integers = new HashSet<>();
 // random and no duplicate
  integers.add(100);
  integers.add(20);
  integers.add(30);
  integers.add(40);
  integers.add(50);

  System.out.println("HashSet:" + integers);
// can duplicate and 
  List<Integer> list = new ArrayList<>();

  list.add(100);
  list.add(10);
  list.add(50);
  list.add(110);
  list.add(200);

  System.out.println("list : "+ list);

  Deque<String> deque = new LinkedList<>();

  //Add at the last
  deque.add("Element 1 (Tail)");
  
  //Add at the first
  deque.addFirst("Element 2 (Head)");

  //Add at the last
  deque.addLast("Elements 3 (Tail)");

   //Add at the first
//  deque.push("Element 4 (Head)");

    //Add at the last
  deque.offer("Element 5 (Tail)");

    //Add at the first
  deque.offerFirst("Element 6 (Head)");

  System.out.println(" \n " + deque );

  deque.removeFirst(); // remove head
  deque.removeLast();  // remove tail 

  deque.pollFirst(); //retrieve + remove head
  deque.pollLast(); //retrieve + remove tail

  deque.peekFirst(); // retrieve head
  deque.peekLast(); //retrieve tail

  deque.pop(); //removeFirst()

  System.out.println(deque);

  








 }
}