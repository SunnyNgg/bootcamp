package com.vtxlab.demo.book.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.vtxlab.demo.book.response.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler<T> {

  @ExceptionHandler({ KeyNotFoundException.class})
  public ResponseEntity<ApiResponse<T>> handleKeyNotFoundException(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(13003,
    "Key Not Found Exception, please check",null));
  }



  
}
