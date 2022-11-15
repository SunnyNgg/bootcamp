package com.vtxlab.app.exception;

import com.vtxlab.app.enums.Exceptions;

public class MobileBackEndException extends BusinessException {

  private int code;

  private MobileBackEndException(){
    super();

  }
  private MobileBackEndException(String s  ){
    super(s );

  }

  private MobileBackEndException(String s, Throwable e  ){
    super(s,e );

  }

  private MobileBackEndException(int code, String s  ){
    this(code + ":" + s);
    this.code =code; 
  }

  private MobileBackEndException(int code, String s, Throwable e){
    this(code + ":" + s,e);
    this.code = code;
  }

  public MobileBackEndException(Exceptions enums){
    this(enums.getcode(), enums.getexceptionMsg());
  }
  
  public MobileBackEndException(Exceptions enums, Throwable e ){
    this(enums.getcode(), enums.getexceptionMsg(), e );
  }
}
