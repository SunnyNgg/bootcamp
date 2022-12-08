package com.vtxlab.demo.openweather.utils;

import com.vtxlab.demo.openweather.model.CurrentWeatherDto;
import com.vtxlab.demo.openweather.model.WeatherDto;
import com.vtxlab.demo.openweather.model.elements.CurrentWeatherResponse;

public class WetherModelMapper {

  public static WeatherDto convert(CurrentWeatherResponse cwr){
    if (cwr == null){
      return null;
    }

    CurrentWeatherDto currentWeatherDto = 
    CurrentWeatherDto.builder()
    .latitude(cwr.getCoordinate().getLatitude())
    .longitude(cwr.getCoordinate().getLongitude())
    .cityId(cwr.getCityId())
    .cityName(cwr.getCityName())
    .humidity(cwr.getMainIndex().getHumidity())
    .cloudinessPercent(cwr.getCloudIndex().getCloudinessPercent())
    .build();


    return WeatherDto.builder().currentWeatherDto(currentWeatherDto).build();


  }
  
}
