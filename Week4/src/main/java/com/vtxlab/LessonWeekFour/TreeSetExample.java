package com.vtxlab.LessonWeekFour;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetExample {
  public static void main(String[] args) {
    
  
  
  SortedSet<String> ts = new TreeSet<>();
  
  ts.add("India");
  ts.add("Australia");
  ts.add("South Africa");

  //Adding the duplicate element
  ts.add("India");

   System.out.println(ts);

   ts.remove("Australia");
   System.out.println("Set after removing Australia :" + ts);

   System.out.println("Iterating over set;");
   Iterator<String> i = ts.iterator();
   while(i.hasNext()){
    System.out.println(i.next());
   }
  }
}
