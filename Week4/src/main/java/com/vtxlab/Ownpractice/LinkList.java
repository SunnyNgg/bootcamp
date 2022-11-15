package com.vtxlab.Ownpractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class LinkList 
{ 
  private int age;

  private LinkList(int age){
    this.age = age;
  }

  public static LinkList ageValueOf (int age)
  {
    return new LinkList (age);
  }

  public static LinkList ageValueOf (String age)
  {
    return new LinkList(Integer.valueOf(age));
  }

  public static LinkList ageValueOf (Float age)
  {
    return new LinkList((int)Math.round(age));
  }


  public static void main(String[] args) 
  {
    LinkedList<String> abc = new LinkedList<>();

    abc.addFirst("a");
    abc.add("b");
    abc.add("c");
    abc.add("d");
    abc.remove("e") ;

    LinkList linklist1 = LinkList.ageValueOf(13);
    LinkList linklist2 = LinkList.ageValueOf("123");
    LinkList linklist3 = LinkList.ageValueOf(13F);

System.out.println(linklist3.age);
System.out.println(linklist2.age);
System.out.println(linklist1.age);

  
  
  }  
}