package com.vtxlab.Quiz1;

import java.util.ArrayList;
import java.util.List;

class Farm{} 

  class Animal{
    private int age; 

    public int getAge(){
      return this.age;
    }
  }

  class Pig extends Animal{}

  class AnimalFram extends Farm{
  List<Animal> animals = new ArrayList<>();

   void setAnimals(Animal pig){
    this.animals.add(pig);
  }

   List<Animal> getAnimals(){
    return this.animals;
  }

  }
  
  public class Quiz13 {
    public static void main(String[] args) {
      AnimalFram animalFram = new AnimalFram();
      animalFram.setAnimals(new Pig());
      for(Animal animal : animalFram.getAnimals()){
        System.out.println(animal.getAge());
      }
    }
  }
