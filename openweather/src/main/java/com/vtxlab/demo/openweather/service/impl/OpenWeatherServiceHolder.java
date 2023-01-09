package com.vtxlab.demo.openweather.service.impl;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.HashMap;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.util.TimeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demo.openweather.exception.ApiException;
import com.vtxlab.demo.openweather.model.elements.CurrentWeatherResponse;
import com.vtxlab.demo.openweather.service.OpenWeatherService;
import com.vtxlab.demo.openweather.utils.RedisKey;
import com.vtxlab.demo.openweather.utils.WeatherApi;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OpenWeatherServiceHolder implements OpenWeatherService {

  @Autowired
  WeatherApi weatherApi;

  @Value("${rest.openweathermap.baseUrl}")
  String baseUrl;

  @Value("${rest.openweathermap.serviceVers}")
  String serviceVers;

  @Value("${rest.openweathermap.serviceUrl}")
  String serviceUrl;

  @Value("${rest.openweathermap.appid}")
  String appid;

  @Autowired
  RedisTemplate<String, CurrentWeatherResponse> redisTemplate;

  @Override
  public CurrentWeatherResponse getCurrentWeather(BigDecimal latitude,
      BigDecimal longitude) throws ApiException {

    // Invoke Weather API
    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("lat", latitude.toString());
    hMap.put("lon", longitude.toString());
    hMap.put("appId", appid);

    String redisKey = RedisKey.API_OPENWEATHER_1 + ":"
        + latitude.toString() + ":"
        + longitude.toString();

        CurrentWeatherResponse currentWeatherResponse = //
        weatherApi.invoke(baseUrl,
            serviceVers, serviceUrl,
            hMap, CurrentWeatherResponse.class,
            redisKey, Duration.ofSeconds(60));

    return currentWeatherResponse;

  }

}
