package com.vtxlab.demo.project.exception;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtxlab.demo.project.model.dto.CoinsMarkets;



@ControllerAdvice
public class GlobalException {

  @ExceptionHandler({ ApiException.class, NullPointerException.class, ArithmeticException.class})

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public List<CoinsMarkets> handleApiException(ApiException e){
    return new ArrayList<>();
  }
  }
    
  
  
