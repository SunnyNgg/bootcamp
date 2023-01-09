package com.vtxlab.demo.openweather.response.enums;

import lombok.Getter;

@Getter
public enum ResponseStatus {
  // code
  // message
  // Succes  20000 - 29999
  OK(20000, "Success."),

  // Fail 
  FAIL(30000, "Fail"),
  THIRD_PARTY_API_FAIL(30001, "Thrid Party Api Fail."),
  THIRD_PARTY_API_TIMEOUT(30002, "Thrid Party Api Timeout."),
  // 30001...
  NPE(70000, "Nullpointer Excepetion."),
  AME(70001, "Arithmetic Exception.")
  ;

  Integer code;
  String message;

  ResponseStatus(Integer code, String message){
    this.message = message; 
    this.code = code; 
  }




  
}
