package com.vtxlab.LessonWeekFour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class HashMapExample {
  public static void main(String[] args) {
    Map<Integer,String> ht = new Hashtable<>();
    ht.put(101, "Ajay");
    ht.put(101, "Vijay");
    ht.put(102, "Ravi");
    ht.put(103, "Rahul");
    ht.replace(101, "Vijay", "abc");
    
    System.out.println("------------Hash table-----------");

    for(Map.Entry m: ht.entrySet()){
      System.out.println(m.getKey()+" "+ m.getValue());
    }
    System.out.println("The size of the map is " + ht.size());
    System.out.println("Initial Mappings are: " + ht);

    Map<Integer, String> hm = new HashMap<>();
    hm.put(100, "Amit");
    hm.put(104, "Amit");
    hm.put(101, "Vijay");
    hm.put(102, "Rahul");
    System.out.println("-----------Hash map-----------");
    for(Map.Entry m : hm.entrySet()){
      System.out.println(m.getKey() + " " + m.getValue());
    }

    Map<Integer, List<String>> ht2 = new Hashtable<>();

    List<String> strings6 = new ArrayList<>();
    strings6.add("abc");
    strings6.add("bcd");
    ht2.put(101,strings6);

    List<String> strings7 = new ArrayList<>();
    strings7.add("abcd");
    strings7.add("bcde");
    ht2.put(102,strings7);
    ht2.size();

    if(ht2.isEmpty())
    {
      
    }
    ht2.toString();

    for(Map.Entry<Integer, List<String>> m : ht2.entrySet()){
      for(String s : m.getValue()){
        System.out.println(s);
      }
    }
  }
}
