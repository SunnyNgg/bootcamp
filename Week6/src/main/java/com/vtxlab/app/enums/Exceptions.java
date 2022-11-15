package com.vtxlab.app.enums;

public enum Exceptions {
  //Timeout Exception 
  TIMEOUT(1000, "Exception - Time out!"), 
  CUSTOMER_WEBSITE_TIMEOUT(1001, "Exception - Customer website Time out"),

  //Duplicated Records 
  DUPLICATED_RECORD(2000, "Exception -Duplicated Record!"), 

  // Bad Gateway
  BAD_GATEWAY(3000, "Exception - Bad Gateway!"), 

  //Token Expiry 
  TOKEN_EXPIRE(4000, "Exception - Token Expire! "),

  //NPE
  NPE(5000, "RunTimeException")
  ;
  
  private int code; 
  private String exceptionMsg; 

  public int getcode(){
    return this.code;
  }

  public String getexceptionMsg(){
    return this.exceptionMsg;
  }

  private Exceptions(int code, String exceptionMsg){
    this.code = code;
    this.exceptionMsg = exceptionMsg;
  }
}
