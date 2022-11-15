package com.vtxlab.model.generics;

/**
 * Exercise: Create a Class with Generics Data Types T, U
 */
/**
 * Expected Output:
 * T t = Venturenix Lab
 * U u = 10
 * T t = Venturenix Lab
 * U u = 12
 */
class Company {
  String name;

  Company(String name) {
      this.name = name;
  }

  public String getName() {
      return this.name;
  }

}

// Exercise: Create a Class with Generics Data Types T, U
// 2 fields, company and noOfStaff
// with get methods and constructor
// Implement a print() method to generate the expected outputs
class Generics<T, U> {
  // code here ...
  T company;
  U noOfStaff;

  Generics(T company, U noOfStaff){
      this.company = company;
      this.noOfStaff = noOfStaff;
  }

  public T getCompany(){
      return this.company;
  }

  public U getNoOfStaff(){
      return this.noOfStaff;
  }

  public static<T, U >void print(T companyName, U noOfStaff) {

      
  }

}

// Driver class to test above
class Exercise30 {

  public static void main(String[] args) {
      Generics<String, Integer> generic = new Generics<>("Venturenix Lab", 10);
      Generics.print(generic.getCompany(), generic.getNoOfStaff());

      Generics<Company, String> generic2 = new Generics<>(new Company("Venturenix Lab"), "12");
      Generics.print(generic2.getCompany().getName(), generic2.getNoOfStaff());
  }
}
