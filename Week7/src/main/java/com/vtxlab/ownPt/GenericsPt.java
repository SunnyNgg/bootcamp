package com.vtxlab.ownPt;

 class MyGenericsTest<Thing extends Number>{

  Thing a; 
  Thing b; 


MyGenericsTest(Thing a, Thing b ){
  this.a = a; 
  this.b = b; 

}

static public void setvalue(String a){
    a = a; 
}

public Thing getvalue(){
  return a; 
} 

public Thing getvalue2(){
  return b; 
}
 }
public class GenericsPt {

  public static void main(String[] args) {
    MyGenericsTest<Integer> myGenericsTest = new MyGenericsTest(123, 123);
    System.out.println(myGenericsTest.getvalue());
    System.out.println(myGenericsTest.getvalue2());
    System.out.println();

    MyGenericsTest.setvalue("1");
    myGenericsTest.getvalue();
  }
  
}
