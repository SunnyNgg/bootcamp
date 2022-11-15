package com.vtxlab.Quiz2;

import java.util.HashMap;
import java.util.Map;

public class Quiz2Q11 {
  static int hashcounter = 0; 
  static Map<Integer, Animal> hashmap = new HashMap<>();
  
  static class Animal { // can 
    String name;

    Animal(String name){
      this.name = name; 
      hashcounter++; //add the Key in the Map 
    }

    String getName(){
      return this.name; 
    }
  }

  public static void addAnimal(Animal animal){
    hashmap.put(hashcounter, animal);
  }

  public static void main(String[] args) {
    addAnimal(new Animal("Yes")); //Key 1
    addAnimal(new Animal("No"));  //Key 2
    addAnimal(new Animal("Yes"));  //Key 3
    addAnimal(new Animal("Nope"));  // Key 4
    System.out.println(hashmap);

    hashmap.remove(3); // remove by key 
    System.out.println(hashmap.get(3).getName()); // hashmap.get(3) -> NPE 
    

    //NullPointerExecption line 32, Map.get(Object) is null
  }
}
