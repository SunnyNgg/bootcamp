package com.vtxlab.Quiz2;

 class CustomException extends RuntimeException{

  public CustomException(){

  }

  public CustomException(String msg, Throwable e ){
    super(msg, e );
  }

  public static int test(){
    throw new CustomException();
  }

   public static void main(String[] args) { 
    test();
  }
}

// No compile error, but runtime erroe, line 14 & 17, unhandled exception 