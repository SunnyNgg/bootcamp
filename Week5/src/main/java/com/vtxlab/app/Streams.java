package com.vtxlab.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.plaf.metal.OceanTheme;

public class Streams {
  public static void main(String[] args) {

    ArrayList<String> arrlist = new ArrayList<>();
    arrlist.add("123");

    List<String> names = Arrays.asList("Peter", "Carl", "Benny", "Benny", "Alex", "Alan");

    Predicate<String> contaniC =  e -> e.contains("C");
    Predicate<String> contaniB =  e -> e.contains("B");
    Predicate<String> lengthLessThan5 = e -> e.length() < 5;
    
    UnaryOperator<String> toUpperCase2 = e -> e.toUpperCase();
    Function<String, String> returnself = e -> e; 
    Function<String, String> toUpperCase = e -> e.toUpperCase();
    Function<String, String> toSubstring = e -> e.substring(0, 3);

    Set<String> filteredNames = names.stream()
    .map(toUpperCase2.andThen(toSubstring))
    .filter(contaniB.and(lengthLessThan5))
    .collect(Collectors.toSet());

    Set<String> removeDuplicated = names.stream().collect(Collectors.toSet());
    System.out.println(removeDuplicated);

    Stream<String> streams = names.stream()
    .filter(name -> name.contains("C")); //intermediate operation
    System.out.println(filteredNames); // [Alex]

//iterate 
    List<Integer> numbers = Stream.iterate(1, n -> n+1)
    .limit(10)
    .collect(Collectors.toList());
    System.out.println(numbers);

    Integer reduced = numbers.stream()
    .reduce(0, (a,b) -> a - b ); // limit(10)
    System.out.println(reduced);

    List<Integer> numbeList = Arrays.asList(9992, 2121, 2184, 5539, 3120);
    Optional<Integer> optional = numbeList.stream()
      .max((o1,o2) -> o1.compareTo(o2));
      optional.ifPresent(e -> System.out.println(e));

    long streamCount = Stream.of(11,12,13).map(i -> {
      System.out.println(i);
      return i + 1;
    }).count();
    
    System.out.println(streamCount);
  }
  
}
