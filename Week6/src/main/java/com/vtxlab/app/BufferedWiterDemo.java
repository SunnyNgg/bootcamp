package com.vtxlab.app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

public class BufferedWiterDemo {

  public static void main(String[] args) throws IOException {
    StringWriter sw = null; 
    BufferedWriter bw = null;
    String letters = "ABCDEFGHIJK";

    try{
      sw = new StringWriter();
      bw = new BufferedWriter(sw);
      
      for(char c: letters.toCharArray()){
        bw.append(c);
        bw.flush();

        System.out.println(sw.getBuffer());
      }
    }catch (IOException e ){
      e.printStackTrace();
    }finally {
      if(sw!=null)
      sw.close();
      if(bw!=null)
      bw.close();
    }


  }
  
}
