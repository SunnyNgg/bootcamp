package com.vtxlab.demo.vtxlabcryptopolygon.exception;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vtxlab.demo.vtxlabcryptopolygon.model.CoinExchange;



@ControllerAdvice
public class GlobalException {

  @ExceptionHandler({ ApiException.class, NullPointerException.class, ArithmeticException.class})

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  public List<CoinExchange> handleApiException(ApiException e){
    return new ArrayList<>();
  }
  }
    
  
  
