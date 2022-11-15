package com.vtxlab.LessonWeekFour.dsa.linkedList;

import java.util.ArrayList;
import java.util.List;
import com.vtxlab.LessonWeekFour.dsa.linkedList.singly.Node;

public class LinkedList {
  Node head;
  
  public LinkedList push(int newData){ 
    Node node = new Node(newData);
    node.setNext(head);
    this.head = node;
    return this;
  }

   public Node peek(){
    return this.head;
}

  public LinkedList deleteNode (int key){
    Node temp = head;
    Node prev = null;
  

  if(temp != null && temp.getData() == key){
    head = temp.getNext();
    return this;
  }

  while (temp != null && temp.getData() != key)
  {
    prev = temp;
    temp = temp.getNext();
    return this;
  }

  if (temp == null)
    return this;

  prev.setNext(temp.getNext());
  return this;
  }
  public LinkedList print(){
    Node tnode = head;
    while(tnode != null){
      System.out.println(tnode.getData() + " ");
      tnode = tnode.getNext();
    }
    return this;
  }

  public static void print(LinkedList ll){
    Node tnode = ll.head;
    while (tnode != null) {
      System.out.println(tnode.getData() + " ");
      System.out.println("This data is odd" + tnode.isNodeDataOdd());
      tnode = tnode.getNext();
    }
  }

  public static void main(String[] args) {

    List <Integer> abc = new ArrayList<>(); 

    LinkedList llist =new LinkedList();

    llist.push(5);
    llist.push(100);
    llist.push(30).push(50).push(20).push(24).push(90);

    System.out.println("");
    LinkedList.print(llist);
  }
}

