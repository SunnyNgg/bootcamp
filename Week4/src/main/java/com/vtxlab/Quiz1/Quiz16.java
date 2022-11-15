package com.vtxlab.Quiz1;

public class Quiz16 {

  static final String string = "IamFinalString";
  private static char c = 'C';

  static{
    char[] chars = string.toCharArray(); // change the String to the Char Array
    c =chars[2]; // "IamfinalString" position number 2 = 'm'
  }
  
  public static void main(String[] args) {
    Quiz16 readitCarefully = new Quiz16(); // new the object
    System.out.println(readitCarefully.c);
  }
}

// Answer is m 