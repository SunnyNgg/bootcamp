package com.vtxlab.Quiz1;

import java.util.ArrayList;
import java.util.List;

public class Quiz17 {

  static final List<Character> characters; 
  private static final char[] chars = {'J' ,'a', 'c', 'k', 'y'};
  int a = 0;


  static{ // static block 
    characters = new ArrayList<>();
    
  }

  {
    characters.add('V'); // Why do not run this code?
  } // excute only when New Object of current class is created 

  public static void main(String[] args) {
    for(char c : chars){
      characters.add(c);
    }
    System.out.println(characters.size());
  }

}