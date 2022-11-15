package com.vtxlab.Quiz2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

enum Food{
  VEGETABLE('V'),
  MAET('M'),
  FRUIT('F')

  ;

  char key;

  Food(char c){
    this.key =c ;
  }
}

public class Quiz2Q13 {
  public static void main(String[] args) {
    List<Food> foods = new ArrayList<>();
    foods.add(Food.VEGETABLE);
    foods.add(Food.MAET);
    foods.add(Food.FRUIT);

    List<Character> mappedList = foods.stream()
    .map(e -> e.key) // form enum to char // map. is a method to transfer 
    .filter( e -> Character.isLowerCase(e)) // return turn false 
    .sorted()
    .collect(Collectors.toList());

    System.out.println(mappedList);

  }
  
  
}
