package com.vtxlab.Quiz2;

interface Animal { //Funtional interface 
  void eat();
}

class Cow implements Animal {
  public void eat(){  // frist method 
    System.out.println("[Cow] eating ...");
  }

  public void eat(Animal a ){  // second method 
    a.eat();
  }

}
public class Quiz2Q2 {
  public static void main(String[] args) {
    Animal cow = new Cow();
    cow.eat(); // Animals only have the frist method 

    Animal smallCow = () ->System.out.println("[Animal] try to eat something ... "); // lambda line 3-4 method 
    smallCow.eat();

    Cow bigCow = new Cow();
    bigCow.eat(smallCow); // method of 12-13 line  , pass by reference 

    //Answer is 
    //"[Cow] eating ..."
    //"[Animal] try to eat something ... "
    //"[Animal] try to eat something ... "
  }
  
  
}
