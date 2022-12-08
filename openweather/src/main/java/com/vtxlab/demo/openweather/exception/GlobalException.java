package com.vtxlab.demo.openweather.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.vtxlab.demo.openweather.controller.impl.OpenWeatherController;
import com.vtxlab.demo.openweather.response.Alert;
import com.vtxlab.demo.openweather.response.ApiResponse;
import com.vtxlab.demo.openweather.response.enums.ResponseStatus;

@ControllerAdvice
public class GlobalException<T> {

  @ExceptionHandler({ ApiException.class})
  public ResponseEntity<ApiResponse<T>> hanlResponseEntity(ApiException e){
    OpenWeatherController.errAlert.add(new Alert(e.getCode() , e.getMessage()));

    return ResponseEntity.badRequest()
    .body(
        new ApiResponse<>(ResponseStatus.THIRD_PARTY_API_TIMEOUT.getCode(),
        ResponseStatus.THIRD_PARTY_API_TIMEOUT.getMessage(),
        null,
        OpenWeatherController.errAlert));
  }

  @ExceptionHandler({ NullPointerException.class})
  public ResponseEntity<ApiResponse<T>> handleNpeException(){
    return ResponseEntity.badRequest().body(
      new ApiResponse<>(ResponseStatus.NPE.getCode(),
      ResponseStatus.NPE.getMessage(),
      null,
      OpenWeatherController.errAlert));
    
  }
  
}
