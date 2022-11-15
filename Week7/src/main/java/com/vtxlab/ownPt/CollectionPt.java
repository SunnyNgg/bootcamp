package com.vtxlab.ownPt;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

 class ReGeneric{
  public static <T> List<T> formArrayToList(T[] a ){
    return Arrays.stream(a).collect(Collectors.toList());
}




public class CollectionPt {
  public static void main(String[] args) {
    
    
    SortedSet <String> ts = new TreeSet<>();

    ts.add("Sunny");
    ts.add("Tom");
    ts.add("Peter");
    ts.add("abc");

    ts.add("Tom");

    System.out.println(ts);

    Map<String, Integer> abc = new HashMap<>();
    abc.put("A", 1);
    abc.put("B", 2);



    System.out.println(abc.get("A"));

    Map<Integer, String> map = new HashMap<>();
    map.put(1, "Sunny");
    map.put(null, "Tom");
    map.put(1, "ABC");
    System.out.println(map.toString());


  }
  
}
 }