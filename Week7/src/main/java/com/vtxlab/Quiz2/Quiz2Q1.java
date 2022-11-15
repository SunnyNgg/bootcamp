package com.vtxlab.Quiz2;

public class Quiz2Q1 {
  private String[] strings;

  Quiz2Q1(String[] strings){
    this.strings = strings;
  }

  public String[] getStrings(){
    return this.strings;
  }

  public static void main(String[] args) {
    Quiz2Q1 p1 = new Quiz2Q1(new String[] { "ABC", "BCD", "XYZ"});
    Quiz2Q1 p2 = p1;
    Quiz2Q1 p3 = new Quiz2Q1(new String[] { "ABC", "BCD", "XYZ"});
    String s1 = "ABC";
    String s2 = "ABC";

    System.out.println(p1 == p2 ); //compare the reference 
    System.out.println(p2 == p3 ); //compare the reference 
    System.out.println(s1 == s2 ); //???? past by Renfence ??
    System.out.println(s1 == p1.getStrings()[1] );  // p1.getStrings = BCD 
    System.out.println(s2.equals(s1) );   // compare the value, so true 
  }
  // Answer
  // true, false, true, false, true 
}
