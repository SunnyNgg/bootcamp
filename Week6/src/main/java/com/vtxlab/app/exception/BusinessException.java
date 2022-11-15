package com.vtxlab.app.exception;



//checked exception
//company level
public class BusinessException extends Exception{

  public BusinessException(){
   super();
  }
  
  public BusinessException(String message ){
    super(message);
  }

  public BusinessException(String message, Throwable casue){
    super(message, casue);
  }
}
