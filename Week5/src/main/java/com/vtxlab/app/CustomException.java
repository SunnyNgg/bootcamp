package com.vtxlab.app;

public class CustomException extends RuntimeException {

  String anotherMsg;

  public CustomException(String msg){
    super(msg);
  }
  
}
