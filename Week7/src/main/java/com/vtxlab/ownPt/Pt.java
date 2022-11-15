package com.vtxlab.ownPt;

import java.time.YearMonth;

class Animal{
  private String name; 


  public Animal(String name){
    this.name = name ;
    
  }

  public String getName(){
    return name;
  }
  public void makeSound(){
    System.out.println("I am " + name);
  }

}

class Dog extends Animal{
  private boolean hasBone; 

  public Dog(String name, boolean hasBone ){
    super(name);
    this.hasBone = hasBone;
  }

  public boolean isHasBone(){
    return hasBone;
  }

  @Override
  public void makeSound(){
    System.out.println("Woof woof my name is " + getName()  );
  }
}

public class Pt {

  
}
