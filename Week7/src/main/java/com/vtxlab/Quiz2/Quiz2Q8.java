package com.vtxlab.Quiz2;

enum Color{ // beacasue the enum is final 
  RED(1), YELLOW(2), BLACK(3)
  ;

  static int counter = 0;
  int value;

  Color(int i ){ // the constructor can add counter
    this.value = i; 
    counter++;
  }
}

public class Quiz2Q8 {
  public static void main(String[] args) {
    System.out.println(Color.counter);
  }
  
  //Compile error, Cannot refer to the static enum field Color.counter within a initializer 
  
  
}
