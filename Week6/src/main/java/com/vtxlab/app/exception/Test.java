package com.vtxlab.app.exception;

import com.vtxlab.app.enums.Exceptions;

public class Test {
  public static void main(String[] args) throws MobileBackEndException {
    
    String s = null;
    try{
      int l = s.length();
    } catch (NullPointerException e ){
      throw new MobileBackEndException(Exceptions.NPE);
    }
  }
  
}
