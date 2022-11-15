package com.vtxlab.Quiz1;



  interface Vegetarian {
    default public String eat(){
      return "[Vegetarain] I am able to eat";
    }
  }

  interface Runner{
    default public String eat(){
      return "[Runner] I am able to eat"; 
    }
  }

  class Pig extends Animal {
    public String eat(){
      return "Pig I am able to eat";
    }
  }

  class Animal{
    public String eat(){
      return "Animal I am able to eat ";
    }
  }

   class SamllPig extends Pig implements Vegetarian, Runner{}

  

  public class Quiz10 {
    public static void main(String[] args) {
      SamllPig samllPig =new SamllPig();
      System.out.println(samllPig.eat());
    }
}
// Small pig Polymorphism directly have the Pig method
//Answer is "Pig I am able to eat "