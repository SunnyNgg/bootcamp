package com.vtxlab.Quiz2;

import java.util.Deque;
import java.util.LinkedList;

class Car{
  int speed = 100;
  static Car instance = new Car(); //important 


private Car(){ //private construtor 

}

public static Car getInstance(){
  return instance;
}

public void setSpeed(int s ){ //already set the speed is 80
  this.speed = s;
}
}
public class Quiz2Q12 {
  public static void main(String[] args) {
    Deque<Car> deque = new LinkedList<>(); 
    Car tesla = Car.getInstance();
    Car toyota = Car.getInstance(); // get the same thing in the tesla 

    tesla.setSpeed(80);

    deque.add(tesla);
    deque.push(toyota);

    System.out.println(deque.getLast().speed + " " + deque.getFirst().speed);
  }
  //answer is 80 80 ; 
}
