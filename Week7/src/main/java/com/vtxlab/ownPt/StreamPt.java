package com.vtxlab.ownPt;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamPt {
//Stream.empty creates an empty stream
  Stream<String> empty = Stream.empty();
// Stream.of() can create a stream with a single element
  Stream<Integer>singleElement = Stream.of(1);
//Stream.of () also accepts varargs
Stream<Integer> multipleElements = Stream.of(1,2,3);
//Convert a list into a stream 
List<String> list = Arrays.asList("a","b", "c");
Stream<String> fromList = list.stream();
//Create an infinite stream of random numbers
Stream<Double> randoms = Stream.generate(Math::random);
//Create an infinite stream of odd numbers staring form 1
Stream<Integer> oddNumbers = Stream.iterate(1, n-> n+2 ); 
//
Stream<Double> randoms1 = Stream.generate(Math::random).limit(10);


                         

public static void main(String[] args) {
   StreamPt stream = new StreamPt();
    System.out.println(stream.randoms1);
    System.out.println(stream.oddNumbers);
    //stream.oddNumbers.forEach(e -> System.out.println());
    //stream.oddNumbers.forEach(System.out::println);

    List<String> names = Arrays.asList("anne", "Belly", "", "t");
 long count = names.stream()
                  .distinct()
                  .count(); 
System.out.println(count);
  
List<String> filteredNames = names.stream()
                                .filter(a -> a.contains("a"))
                                .collect((Collectors.toList()));
                                System.out.println(filteredNames);
// filter return Predicate 

List<String> mappingNames = filteredNames.stream()
                                 .map(a -> a.toUpperCase())
                                .collect(Collectors.toList());
                                System.out.println(mappingNames);
// map return Function

List<String> sortedNames = mappingNames.stream()
                                .sorted()
                                .collect(Collectors.toList());
                                System.out.println(sortedNames);
//sorted return Comparble

}
  
}
