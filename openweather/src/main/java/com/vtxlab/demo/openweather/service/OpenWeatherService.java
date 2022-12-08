package com.vtxlab.demo.openweather.service;

import java.math.BigDecimal;
import com.vtxlab.demo.openweather.exception.ApiException;
import com.vtxlab.demo.openweather.model.elements.CurrentWeatherResponse;

public interface OpenWeatherService {

  public CurrentWeatherResponse getCurrentWeather(BigDecimal latitude,
  BigDecimal longitude) throws ApiException;
  
}
