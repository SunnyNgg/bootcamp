package com.vtxlab.demo.openweather.controller;


import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.demo.openweather.exception.ApiException;
import com.vtxlab.demo.openweather.model.OpenWeatherDto;
import com.vtxlab.demo.openweather.model.WeatherDto;
import com.vtxlab.demo.openweather.model.elements.SystemInternal;
import com.vtxlab.demo.openweather.model.elements.WeatherIndex;
import com.vtxlab.demo.openweather.response.ApiResponse;

@RequestMapping(value = "/default")
public interface OpenWeatherOperation  {


  @GetMapping (value = "/weather")
  public ResponseEntity<ApiResponse<WeatherDto>> getWeather(
    @RequestParam(name = "lat") BigDecimal lantitude, 
    @RequestParam (name = "lon ")BigDecimal longitude) throws ApiException ;

  /* 
  @GetMapping (value = "/weathers")
  public List<WeatherIndex> getWeatherStation(@RequestParam BigDecimal latitude, @RequestParam  BigDecimal longitude)throws ApiException ;

  @GetMapping (value = "/sys")
  public SystemInternal getSys(@RequestParam BigDecimal latitude, @RequestParam BigDecimal longitude) throws ApiException;
  */
}