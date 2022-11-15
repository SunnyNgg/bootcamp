package com.vtxlab.app;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import com.vtxlab.model.Lambda.String1;

interface FunctionalInterface {
     
    void getAge (int x);

    default void sayHello(){
      System.out.println("Hello");
    }

    default void sayBye(String name ){
      System.out.println("sayByeBye" + name );
    }
    
  }


  
  public class Lambda {

    public static void main(String[] args) {

      Map<String, Integer> nameLengthMap = new HashMap<>();
      //nameLengthMap.put("Peter", 6);
      // We are writing a formula to calculate the length of input "String"
      Function<String, Integer> computeLenght = String :: length;

      // 1.check if the key exists in the map
      // 2.if no calculatee value according to my formula
      // 3.put the key & value (entry) to the map 

      Integer computeValue = nameLengthMap.computeIfAbsent("Peter", computeLenght);

      System.out.println(("Fuction computeValue = " + computeValue));

      // BiFunaction 
      Map <String, Integer> nameFrequencyMap = new HashMap<>();
      nameFrequencyMap.put("Peter", 3);
      //equivalent to (oldValue, newValue ) -> oldvalue + newValue
      //BiFunction<Integer, Integer, Integer>mergeFrquencyByName =Integer :: sum;

      BiFunction<Integer, Integer, Integer>mergeFrquencyByName = (a, b) -> a + b;
      // (a, b) -> {return b; }; 
      //1. "Peter" is a key to find the value in the map.entry
      //2. Ten compute the return value and second parameter according to my formula
      //3. 3 + 4 = 7
      //4. Finally update the value to 7 for key "Peter"

      Integer mergedValue = nameFrequencyMap.merge("Peter", 1, mergeFrquencyByName);
      System.out.println("BiFunction mergedValure = " + mergedValue);

      

      
      List<String> names = Arrays.asList( "Peter", "Paul", "Mary");
      FunctionalInterface abc = x -> System.out.println(2 * x ); 

      for(String name : names){
        System.out.println("hello" + name );

      }

      names.forEach(na -> {
        System.out.println("forEach Help" + na);
        System.out.println("forEach Help" + na);
      });

      abc.getAge(5);
      abc.sayBye("abc");

     String1 c =  x -> {
         StringBuilder sb = new StringBuilder(); 
        sb.append("[");
        for(int i = 0; i < x; i++){
          sb.append(i);
          if(i < x -1){
            sb.append(" , ");
          }
        }
        sb.append("]");
        return sb.toString();
      };
      System.out.println(c.print(5));
    }
}
