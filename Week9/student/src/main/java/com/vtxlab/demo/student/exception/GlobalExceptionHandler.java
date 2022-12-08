package com.vtxlab.demo.student.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.vtxlab.demo.student.response.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler <T> {

  @ExceptionHandler({Exception.class})
  public ResponseEntity<ApiResponse<T>> handleKeyException(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(13001,"Exception", null));
  }
  
}
