package com.vtxlab.Quiz2;

@FunctionalInterface
interface AreaHelper {
  double area();
}

abstract class Shape{
  public String color;


public static <T extends Shape & AreaHelper> double calcArea(T... ts){ // T need to extends the Shape and implement AreaHelper
  double totalArea = 0d; 
  for(T t: ts){
    totalArea += t.area();
  }
  return totalArea; 
  }
}

class Rectangular extends Shape implements AreaHelper {
   int length;
   int width; 

   Rectangular(int x, int y ){
    this.length = x; 
    this.length = y; 
   }
 
   @Override
   public double area(){
    return this.length * this.width;
   }
}

class Square implements AreaHelper{ // No extends to Shape 

  int length;

  Square(int x){
    this.length =x ;
  }

  @Override
  public double area(){
    return this.length * this.length; 
  }


}

public class Quiz2Q10 {
  public static void main(String[] args) {
    double area = Shape.calcArea(new Rectangular(3, 4), new Square(5));
    System.out.println(area);
  }

   // Compile error, class Square didn't extends class Shape
}
