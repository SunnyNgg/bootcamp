package com.vtxlab.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaSupplier {

  public interface Supplier<T>{
    T get();
  }


  public interface Cosumer<T>{
    void accept(T t );

  }


  

public static void main(String[] args) {


  //lambda passed in as *Consumer*
  List<String> names =Arrays.asList("Peter", "Paul", "Mary");

  //Lambda 
  Consumer<String> printName = name -> System.out.println("Hello " + name);
  names.forEach(printName);


//BiConSumer 
  Map<String, Integer> ages = new HashMap<>();
  ages.put("Tom", 18);
  ages.put("Andy", 19);
  ages.put("Denny", 20);

  BiConsumer<String, Integer> printNameAndAge = (name, age) -> 
   System.out.println(name + " is " + age + " years old ");
   ages.forEach(printNameAndAge);

  //string.starsWith(prefix)
  // Predicate 
  List<String> abc = Arrays.asList("Alex", "Amy", "Ben", "Charlotte", "Dicky");

  Predicate<String> starsWithA = name -> name.startsWith("A");

  if(starsWithA.test("Alex")){
    System.out.println("Yes");
  }

  List<String> filteredNames = names.stream().filter(starsWithA).collect(Collectors.toList());

  //BiPredicate
  BiPredicate<String, String> starsWithPrefix =(string, prefix) -> string.startsWith(prefix);

  System.out.println(starsWithPrefix.test("World", "Hello"));
  System.out.println(starsWithPrefix.test("Hello", "Hello"));
  System.out.println(starsWithPrefix.test("HelloWorld", "Hello"));
  System.out.println(starsWithPrefix.test("", "Hello"));
  System.out.println(starsWithPrefix.test("hell", "Hello")); //false 
  System.out.println(starsWithPrefix.test("hell", "")); //NPE

  // Combibing Predicates 
  Predicate<String> startsWithV = a -> a.startsWith("V");
  Predicate<String> endsWithT = x -> x.endsWith("T");

  Predicate<String> combined = startsWithV.and(endsWithT);
  Predicate<String> combined2 = startsWithV.or(endsWithT);

  System.out.println(combined.test("VINCENT"));
  System.out.println(combined2.test("Sunny"));
  



  

  Supplier<Integer> supplyARandomInteger = () -> new Random().nextInt(10) +1;
  System.out.println(supplyARandomInteger.get());

  Supplier<LocalDate> supplyDateOfToday = () -> LocalDate.now();
  System.out.println(supplyDateOfToday.get());


  
}
}
