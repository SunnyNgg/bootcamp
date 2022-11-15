package com.vtxlab.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import com.vtxlab.app.enums.Exceptions;
import com.vtxlab.app.exception.MobileBackEndException;


class PizzaOrderingExecption extends Exception{
  public PizzaOrderingExecption (String msg){
    super(msg);
  }

  public PizzaOrderingExecption(String msg, Throwable e){
    super(msg, e);
  }
}

public class ExceptionTest {

  public int getSomeInteger(String filePath){
    try{
      Scanner scanner = new Scanner(new File(filePath));
      return Integer.parseInt(scanner.nextLine());
    } catch (FileNotFoundException e ){
       System.out.println("File not found! Returning 0...");
       return 0; 
    }


  }

  public static void main(String[] args) throws IOException, MobileBackEndException{
    Path filePath = Paths.get("someFile.txt");
    List<String> lines = Files.readAllLines (filePath);
    System.out.println(lines);

    String s = null;
    try{
      int l = s.length();
    } catch (NullPointerException e ){
      throw new MobileBackEndException(Exceptions.NPE);
    }


    
  }
  
}
