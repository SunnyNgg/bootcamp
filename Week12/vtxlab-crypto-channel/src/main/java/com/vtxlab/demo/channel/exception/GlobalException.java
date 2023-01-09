package com.vtxlab.demo.channel.exception;


import java.nio.channels.Channel;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.channel.response.ApiResponse;
import com.vtxlab.demo.channel.response.ResponseData;
import com.vtxlab.demo.channel.response.enums.ResponseStatus;

@ControllerAdvice
public class GlobalException {

  @ExceptionHandler({ ApiException.class})

  public ResponseEntity<ApiResponse<? extends ResponseData>> handleResponseEntity(
    ApiException e){
    //ChannelApi.setAlerts(new Alert(e.getCode() , e.getMessage()));

    return ResponseEntity.badRequest()
    .body(
        new ApiResponse<>(ResponseStatus.THIRD_PARTY_API_TIMEOUT.getCode(),
        ResponseStatus.THIRD_PARTY_API_TIMEOUT.getMessage(),
        new ResponseData(),
        new ArrayList<>()));
  }

  @ExceptionHandler({ NullPointerException.class, ArithmeticException.class })
  public ResponseEntity<ApiResponse<? extends ResponseData>> handleRuntimeException(RuntimeException e ){
    Integer code =null;
    String message = "";
    if (e instanceof NullPointerException){
      code = ResponseStatus.NPE.getCode();
      message = ResponseStatus.NPE.getMessage();
    } else if (e instanceof ArithmeticException){
      code = ResponseStatus.AME.getCode();
      message = ResponseStatus.AME.getMessage();
    }
    return ResponseEntity.badRequest().body(
      new ApiResponse<>(code,
      message,
      null,
      new ArrayList()));
    
  }
  
}
