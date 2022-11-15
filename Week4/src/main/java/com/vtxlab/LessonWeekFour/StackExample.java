package com.vtxlab.LessonWeekFour;

import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.stream.Stream;
import javax.lang.model.element.Element;

public class StackExample {

  public static void main(String[] args) {
    
    Stack<Integer> stack = new Stack<>();

    System.out.println("Initial stack : " + stack);

    System.out.println("Is stack Empty? :" + stack.isEmpty());

    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);

    System.out.println("Stack after push operation:" + stack);

    System.out.println("Element pooped out: " + stack.pop());

    System.out.println("Stack after Pop Operation: " + stack);

    System.out.println("Element 10 found at position: " + stack.search(10));
    
    System.out.println("Is Stack empty? : " +stack.isEmpty() );

    System.out.println("Stack elements using Java 8 forEach: ");

    Stream stream = stack.stream();

    stream.forEach((element) ->{
      System.out.println(element + " ");
    });




  }


  
}
