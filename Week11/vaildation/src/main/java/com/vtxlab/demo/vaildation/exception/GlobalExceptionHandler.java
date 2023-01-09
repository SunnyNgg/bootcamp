package com.vtxlab.demo.vaildation.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vtxlab.demo.vaildation.model.Payment;
import com.vtxlab.demo.vaildation.response.ApiRespone;

public class GlobalExceptionHandler {

  @ExceptionHandler({MethodArgumentNotValidException.class})
  public ResponseEntity<ApiRespone<Payment>> handleMethodArgurmentException(
    MethodArgumentNotValidException e){
      ApiRespone<Payment> apiRespone = ApiRespone.<Payment>builder()
      .code(e.getStatusCode().value())
      .message(e.getAllErrors().get(0).getDefaultMessage())
      .data(null)
      .build();

      return ResponseEntity.badRequest().body(apiRespone);

    }
  
  
}
