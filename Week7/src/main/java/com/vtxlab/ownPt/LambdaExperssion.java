package com.vtxlab.ownPt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class LambdaExperssion {

  

  public static void main(String[] args) {
    

  Map<String, Integer> nameLengthMap = new HashMap<>(); // object
  Function<String, Integer> computeLength = s -> s.length(); // method 

  Integer computeValue = nameLengthMap.computeIfAbsent("Peter", computeLength); //use the method to the object 
  
  System.out.println(computeValue);

  Map<String, Integer>nameFrequencyMap = new HashMap<>();
  nameFrequencyMap.put("Peter", 6); // Hash Map 1 

  BiFunction<Integer, Integer, Integer> mergeFrequencyByName = (a,b) -> a*b; //method , 3 Integer is the return key 
  Integer mergedValue = nameFrequencyMap.merge("Peter",4, mergeFrequencyByName); //HashMap 2 // there have two different HashMap 
  System.out.println(mergedValue);
  

  BinaryOperator<String> b1 = (x, y) -> x.concat(y);
  //BinaryOperator<String> b1  = String::concat ; 
  System.out.println(b1.apply("YO", "Happy"));

  //Supplier 得出無入 without any input 
    Supplier<Integer> supplyARandomInteger = () -> new Random().nextInt(100)+1;
    System.out.println(supplyARandomInteger.get());

  //Consumer 得入無出 with one parameter but not return anything 
   List<String> names = Arrays.asList("Peter", "Anne", "Mary");
   Consumer<String> printName = a -> System.out.println("Hello"+ a); 
   names.forEach(printName);

   Collections.sort(null);


  }
}