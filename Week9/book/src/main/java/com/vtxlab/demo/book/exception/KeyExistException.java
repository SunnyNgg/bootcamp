package com.vtxlab.demo.book.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class KeyExistException extends RuntimeException {

  private int code;

  public KeyExistException(int code, String msg){
    super(msg);
    this.code = code;

  }
  
}
