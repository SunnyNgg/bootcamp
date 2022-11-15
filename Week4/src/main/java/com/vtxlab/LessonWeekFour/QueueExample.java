package com.vtxlab.LessonWeekFour;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
  public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();

    for(int i = 0; i <5; i++){
      q.add(i);
    }
      System.out.println("Elements of queue " + q );

      int removerElement = q.remove();
      System.out.println("removed element-" + removerElement);

      System.out.println(q);

      int head = q.peek();
      System.out.println("head of queue-" + head);

      //to remove head of queue and return it 
      System.out.println("removed head of queue-" + q.poll());
      System.out.println(q);

      int size = q.size();
      System.out.println("size of queue-" + size);

  }
  
}
