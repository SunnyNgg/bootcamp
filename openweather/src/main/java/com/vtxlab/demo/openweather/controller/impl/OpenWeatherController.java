package com.vtxlab.demo.openweather.controller.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.openweather.controller.OpenWeatherOperation;
import com.vtxlab.demo.openweather.exception.ApiException;
import com.vtxlab.demo.openweather.model.WeatherDto;
import com.vtxlab.demo.openweather.model.elements.CurrentWeatherResponse;
import com.vtxlab.demo.openweather.response.Alert;
import com.vtxlab.demo.openweather.response.ApiResponse;
import com.vtxlab.demo.openweather.response.enums.ResponseStatus;
import com.vtxlab.demo.openweather.service.OpenWeatherService;
import com.vtxlab.demo.openweather.service.impl.OpenWeatherServiceHolder;
import com.vtxlab.demo.openweather.utils.WetherModelMapper;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class OpenWeatherController implements OpenWeatherOperation {

  @Autowired
  OpenWeatherService openWeatherService;

  //@Autowired
  //ModelMapper modelMapper;

  public static List<Alert> errAlert = new ArrayList<>();



  @Override
  public ResponseEntity<ApiResponse<WeatherDto>> getWeather(BigDecimal lantitude, BigDecimal longitude) throws ApiException {
     CurrentWeatherResponse currentWeatherResponse =  openWeatherService.getCurrentWeather(lantitude, longitude);

     if (currentWeatherResponse == null){
      log.info("it is null");
     }
     Integer responseCode = currentWeatherResponse.getCode() == 200?
      ResponseStatus.OK.getCode() :
      ResponseStatus.THIRD_PARTY_API_FAIL.getCode(); 

      String responseMsg = currentWeatherResponse.getCode() == 200?
      ResponseStatus.OK.getMessage():
      ResponseStatus.THIRD_PARTY_API_FAIL.getMessage();

      WeatherDto weatherDto = WetherModelMapper
                              .convert(currentWeatherResponse);

      ApiResponse<WeatherDto> apiResponse = ApiResponse.<WeatherDto>builder()
      .code(responseCode)
      .msg(responseMsg)
      .data(weatherDto)
      .alerts(errAlert)
      .build();

      return ResponseEntity.ok().body(apiResponse);



  }
/* 
  @Override
  public List<WeatherIndex> getWeatherStation( BigDecimal latitude, BigDecimal longitude)throws ApiException ; {
    List<WeatherIndex> weather = CurrentWeatherResponse.getCurrentWeather(latitude, BigDecimal).getWeather().stream()
    .map(e -> modelMapper.map(e, WeatherIndex.class))
    .collect(Collectors.toList());

    return weather;
  }

  @Override
  public SystemInternal getSys(String lat, String lon)throws ApiException  {
    SystemInternal sys = openWeatherService.getWeather(lat, lon).getSys();
    return sys;
  }

*/
}
