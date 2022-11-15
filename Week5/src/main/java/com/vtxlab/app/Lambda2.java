package com.vtxlab.app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import javax.swing.event.SwingPropertyChangeSupport;
import com.vtxlab.model.customer.Customer;




public class Lambda2 {
  public String getString(Customer customer){
    return customer == null ? "0" : customer.getName();
  }
  public static void main(String[] args) {



    
    Function<Integer, String> function =  i -> "abc";
    Function<Integer, int[]> f2 = (a) -> new int[] {1, 2, 3};

    Function<Integer, Map<String, String>> f3 = (b) -> new HashMap<>();

    Function<Integer, int[]> f4 = (a) ->{
      if (a == 4){
        return new int[] {1,2,3};
      }
      return new int[] {1,2,3};
    };
    //implement the logic for the method Function.apply()
    Function<Integer, int[]> arrayWithSize = (a) -> new int[a];

    int[] integers = arrayWithSize.apply(5);

    BiFunction<Integer, Integer, Double[]> arrayWithSize2 =(a,b) -> new Double[a + b];

    Double[] arr = arrayWithSize2.apply(4, 5);

    Function<Integer, Integer> randomNumber = (range) -> (int)(Math.random() * range);
    System.out.println(randomNumber.apply(1000));

    Function<Long, LocalDate> nextWeek = (days) -> LocalDate.now().plusDays(days);
    System.out.println(nextWeek.apply(7l));
    

    Supplier<LocalDate> sevenDaysLater = () ->LocalDate.now().plusDays(7l);
    //System.out.println("Supplier method"+ sevenDaysLater.get());

    Consumer<Integer> sevenDaysLater2 = (x) -> System.out.println(LocalDate.now().plusMonths(1));

    Consumer<Object> number = x -> {
      if(x instanceof Number){ //check if x is a child class of Number
        System.out.println(x.toString());
        System.out.println(((Number) x).intValue());
      }
    };
  number.accept(123);

  System.out.println("Supplier method = "+ sevenDaysLater.get());
  System.out.println("Function method = "+ nextWeek.apply(10l));
 // System.out.println("Comsumer methed = "+ sevenDaysLater2.accept());

    Predicate<Integer> lesserthan = i -> (i < 18);

    System.out.println(lesserthan.test(200));

    Predicate<Integer> greaterThanTen = (i) -> i > 10;

    Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
    boolean result = greaterThanTen.and(lowerThanTwenty).test(15);
    boolean result2 = greaterThanTen.and(lowerThanTwenty).test(20);

    System.out.println("Result Greater Than Ten = " + result);
    System.out.println("Result 2 Greater Than Ten = " + result2);

    UnaryOperator <String> string = x ->{
      ////.........
      return x.toLowerCase();
    };
    //if and only if the implemention can be completed in one line 
    //skip bracket and return keyword
    UnaryOperator <String> toLowercase = x -> x.toLowerCase();
    UnaryOperator <String> replaceCWithA = x -> x.replace("c", "a");

    String s = toLowercase.apply("CCC");
    String s2 = toLowercase.andThen(replaceCWithA).apply("CCC");
    System.out.println(s2);

    String s4 = "CCC".toLowerCase(); // equals to line 86
    String s3 = s.toLowerCase();


    //BinaryOperator e.g Merge Int Array
    BinaryOperator <int []> mergeIntArray = (x, y) -> {
      int [] z = new int[x.length + y.length] ;
      for(int i = 0 ; i < x.length; i++){
        z[i] = x[i];
      }
      for (int j = 0; j < y.length; j++){
        z[x.length + j] = y[j];
      }
      return z; 
    };

    int[] newArray = mergeIntArray.apply(new int[] {3,2,1}, new int[] {10,30 ,20});
    //Arrays.sort(newArray);
    // count how many 0 of newArray currenly has 
    int count = 0;
    for(int k = 0; k < newArray.length; k++){
      if(newArray[k] == 0 ){
        count++;
      }
    }
    int[] o = new int [newArray.length - count];

    int c = 0;
    for(int j= 0; j < newArray.length; j++){
      if(newArray[j] != 0){
        o[c] = newArray[j];
        c++;
      }
    } 
    Arrays.sort(o);
    System.out.println(Arrays.toString(o));

    //Predicate
    Predicate<String> lengthSamllerThan5 = x -> x.length() < 5;
    System.out.println(lengthSamllerThan5.test("ancd")); // true
    System.out.println(lengthSamllerThan5.test("dasfaa")); // false
    BiPredicate<String, String> compareStringHash = (x, y) -> x.hashCode() == y.hashCode();
    System.out.println(compareStringHash.test("abc", "abc"));
    System.out.println(compareStringHash.test("abc", "abcd"));

    String s10 = "abcd";
    System.out.println(s10.hashCode());
    String s9 = "";
    String s8 = "null";
    String s7 = "null ";
    String s6 = "  ";
    String s5 = null;
     if(! Objects.isNull(s9)){
      System.out.println("s9 is blank " + s9.isBlank()); // true
      System.out.println("s9 is empty " + s9.isEmpty()); // true
     }
    //s8
    if(! Objects.isNull(s8)){
      System.out.println("s8 is empty " + s8.isBlank()); // false
      System.out.println("s8 is blank " + s8.isEmpty()); // false
    }
      if(! Objects.isNull(s7)){
      System.out.println("s7 is blank " + s7.isBlank()); // false
      System.out.println("s7 is empty " + s7.isEmpty()); // false
    }
      if(! Objects.isNull(s6)){
      System.out.println("s6 is blank " + s6.isBlank()); // true
      System.out.println("s6 is empty " + s6.isEmpty()); // false 
      }
      if(! Objects.isNull(s5)){
        System.out.println("s5 is blank " + s5.isBlank()); // true
        System.out.println("s5 is empty " + s5.isEmpty()); // false 
      }
      else {
        System.out.println("s5 is null");
      }



  }
}
