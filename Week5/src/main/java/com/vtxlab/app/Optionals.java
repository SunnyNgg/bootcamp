package com.vtxlab.app;

import java.util.Optional;

public class Optionals {

  public String getName(){
    return "Tommy";
  }

  public static Optional <String> getOptionalName (){
    return Optional.of("Tommy");
    //return Optional.empty();
  }

  public static void main(String[] args) {
    
    Optional <String> s = getOptionalName();

    String s2 = s.orElse("Steve"); // NoSuchElementException
    System.out.println(s2);
    
    s.ifPresent(e -> {
      System.out.println(s.get());
    });

    Optional<String> opt2 = Optional.ofNullable(null);
    String defaulWithOrElse2 = opt2.orElse("default value");
    System.out.println(defaulWithOrElse2);

    s.ifPresent( e ->{
      System.out.println(e.length());
    }); // ifPresent -> Consumer (void) 
  }
  
}
