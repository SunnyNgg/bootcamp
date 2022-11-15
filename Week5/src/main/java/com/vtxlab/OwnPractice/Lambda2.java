package com.vtxlab.OwnPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda2 {
  public static void main(String[] args) {
    
  
  ArrayList<String> names  =new ArrayList<>();
  names.add("Peter");
  names.add("Sunny");
  names.add("Alan");
  names.add("Benny");
  names.add("Sunny");

  Predicate<String> containP = e -> e.contains("P");
  Predicate<String> containS = e -> e.contains("S");

  UnaryOperator<String> toUpperCase2 = e -> e.toUpperCase();


  List<String> filteredNames = names.stream()
  .filter((containP.or(containS)))
  .collect(Collectors.toList());
  System.out.println(filteredNames);

  Set<String> streams = names.stream()
  .filter(name -> name.contains("B"))
  .collect(Collectors.toSet());
  System.out.println(streams);

  List<Integer> number = Stream.iterate(2, n -> n+2)
  .limit(10)
  .collect(Collectors.toList());
  System.out.println(number);

  List<Integer> numberList = new ArrayList<>(Arrays.asList(9992,2121,2184,5539,3120));
  numberList.add(123);
  Optional<Integer> optional = numberList.stream()
  .max((o1, o2) -> o1.compareTo(o2));
  optional.ifPresent(e -> System.out.println(e));
  System.out.println(numberList.toString());


  
}

}