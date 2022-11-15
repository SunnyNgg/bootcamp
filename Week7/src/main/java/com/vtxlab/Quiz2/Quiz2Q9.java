package com.vtxlab.Quiz2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Tesla implements Comparator<Tesla>{
  String name;

  String getName(){
    return this.name;
  }

  Tesla(){}

  Tesla(String name){
    this.name =name;
  }

  public int compareTo(Tesla tesla){
    return tesla.getName().compareTo(this.name);
  }

  public int compareTo(Tesla a1, Tesla a2){
    return compare(a2, a1); 
  }

   @Override
  public int compare(Tesla a1, Tesla a2 ){
    return a1.getName().compareTo(a2.getName());
  }
}


public class Quiz2Q9 {
   public static void main(String[] args) {
    List<Tesla> animals = new ArrayList<>();
    animals.add(new Tesla("Leo"));
    animals.add(new Tesla("Kitty"));
    animals.add(new Tesla("Sue"));
    animals.add(new Tesla("Cherry"));
   

   Collections.sort(animals, new Tesla("Vincent"));  // Vincent is Comparetor
   //beacuse in the sorting, so it can't add the new element in the list

   animals.forEach(e -> System.out.println(e.getName()));
   }
}
