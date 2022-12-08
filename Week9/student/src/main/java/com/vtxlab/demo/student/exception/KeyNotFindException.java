package com.vtxlab.demo.student.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class KeyNotFindException extends RuntimeException {

  private int code;

  public KeyNotFindException(int code, String message) {
    super(message);
    this.code =code;

  }


  
}
