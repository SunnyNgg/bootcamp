package com.vtxlab.poly;

public class ChildClassA extends ParentClass {

  public void doSomething(){
    System.out.println("I am a child A");
  }
  
  public static void main(String[] args) {

    ParentClass o1 = new ParentClass();
    ParentClass o2 = new ChildClassA();
    ParentClass o3 = new ChildClassB();

   o1.doSomething();
   o2.doSomething();
   o3.doSomething();
  }


}
