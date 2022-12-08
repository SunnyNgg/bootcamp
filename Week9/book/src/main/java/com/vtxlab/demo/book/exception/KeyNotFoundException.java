package com.vtxlab.demo.book.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class KeyNotFoundException extends RuntimeException {

  private int code;

  public KeyNotFoundException(int code, String msg){
    super(msg);
    this.code =code;

  }
  
}
