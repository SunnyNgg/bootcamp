package com.vtxlab.demo.openweather.model;

import java.io.Serializable;
import java.util.List;
import com.vtxlab.demo.openweather.model.elements.CloudIndex;
import com.vtxlab.demo.openweather.model.elements.Coordinate;
import com.vtxlab.demo.openweather.model.elements.MainIndex;
import com.vtxlab.demo.openweather.model.elements.Rain;
import com.vtxlab.demo.openweather.model.elements.SystemInternal;
import com.vtxlab.demo.openweather.model.elements.WeatherIndex;
import com.vtxlab.demo.openweather.model.elements.WindIndex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class OpenWeatherDto implements Serializable{

  private Coordinate coord;  
  private List<WeatherIndex> weather ;
  private String base;
  private MainIndex main ; 
  private Integer visibility;
  private Rain rain;
  private CloudIndex clouds;
  private WindIndex wind;
  private Integer dt;
  private SystemInternal sys;
  private String timezone;
  private Integer id;
  private String name;
  private Integer cod;


    }
    /* 
   {
  "coord": {
    "lon": 10.99,
    "lat": 44.34
  },
  "weather": [
    {
      "id": 501,
      "main": "Rain",
      "description": "moderate rain",
      "icon": "10d"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 298.48,
    "feels_like": 298.74,
    "temp_min": 297.56,
    "temp_max": 300.05,
    "pressure": 1015,
    "humidity": 64,
    "sea_level": 1015,
    "grnd_level": 933
  },
  "visibility": 10000,
  "wind": {
    "speed": 0.62,
    "deg": 349,
    "gust": 1.18
  },
  "rain": {
    "1h": 3.16
  },
  "clouds": {
    "all": 100
  },
  "dt": 1661870592,
  "sys": {
    "type": 2,
    "id": 2075663,
    "country": "IT",
    "sunrise": 1661834187,
    "sunset": 1661882248
  },
  "timezone": 7200,
  "id": 3163858,
  "name": "Zocca",
  "cod": 200
}              
    */

