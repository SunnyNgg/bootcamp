package com.vtxlab.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ArithmeticExceptionDemo {

  public static void main(String[] args) {

//ArithmeticException
    try{
      int a = 30, b =  0;
      int c = a/b;
      System.out.println("Result = " + c);
    }
    catch(ArithmeticException e ){
      System.out.println("ArithmeticException: Can't divide a number by 0 ");
    }

//ArrayIndexOutOfBoundsException 
    try{
      int a[] =new int [5];
      a[6] = 9; 

    }
    catch(ArrayIndexOutOfBoundsException e ){
      System.out.println("ArrayIndexOutOfBoundsException: Array Index is Out of Bounds");
    }

// Class Not Found Exception 
    try{
      Class.forName("Class1");
    }
    catch (ClassNotFoundException e ){
      System.out.println("ClassNotFoundException: Class Not Found..." + e );
    }

// FileNotFound 
    try{
      File file = new File("E://file.txt");

      FileReader fr = new FileReader(file);
    }

    catch(FileNotFoundException e ){
      System.out.println("FileNotFoundException: File does not exist");
    }

// IOException  
    Scanner scan = new Scanner("Hello Geek!");
    System.out.println("" + scan.nextLine());
    System.out.println("Exception Output:" + scan.ioException());
    scan.close(); //???

// NullPointerException
    try{
      String a = null;
      char b = a.charAt(0);
    } catch (NullPointerException e ){
      System.out.println("NullPointerException..");
    }

// NumberFormatExeption 
    try{
      int num = Integer.parseInt("dada");
    System.out.println(num);
    } catch (NumberFormatException e){
      System.out.println("Number format exception");
    }

 // StringIndexOutBoundsException 
    
   try{
      String a = "This is like chipping";
      char c = a.charAt(24);
      System.out.println(c);
    }
    catch(StringIndexOutOfBoundsException e){
      System.out.println("String Index Out of Bound Exception");
    }

    // Illegal Argument Exception 

    

  }
}
