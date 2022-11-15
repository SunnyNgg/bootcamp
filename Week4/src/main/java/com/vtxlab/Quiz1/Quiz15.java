package com.vtxlab.Quiz1;


class Animal{
  void eat(){
    System.out.println("Animial eating something..");
  }
}

class Cow extends Animal {

  void eat(String food ){
    System.out.println("Cow eating" +  food + "....");
  }

}
public class Quiz15 {

  public static void main(String[] args) {
    Animal cow = new Cow();
    cow.eat("Something"); // the Animal do not have the signature of the method 
  }

   Animal cow2 = new Animal();
   cow2.eat("Somthing"); //Animal new the Aniaml object. it do not have the void eat(String food) method

//Answer is Complile error 


  
}
