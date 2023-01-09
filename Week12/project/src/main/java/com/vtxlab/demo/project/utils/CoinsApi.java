package com.vtxlab.demo.project.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtxlab.demo.project.exception.ApiException;
import com.vtxlab.demo.project.model.CoinsCurrency;
import com.vtxlab.demo.project.model.dto.ChannelDto;
import com.vtxlab.demo.project.model.dto.CoinsMarkets;
import com.vtxlab.demo.project.model.dto.ChannelDto.ExchangeRate;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CoinsApi {

  @Autowired
  RestTemplate restTemplate;

  public static List<ChannelDto.ExchangeRate> map(
    Map<String, CoinsCurrency> coinsCurrencyMap){

      List<ChannelDto.ExchangeRate> exchangeRates =new ArrayList<>();

      for(Map.Entry<String, CoinsCurrency> entry : coinsCurrencyMap.entrySet()){
        // Set Crypto to USD
        ExchangeRate exchangeRate = new ChannelDto().new ExchangeRate();
        exchangeRate.setFromCurr(entry.getKey());
        exchangeRate.setToCurr("USD");
        exchangeRate.setRate(entry.getValue().getUsd());
        exchangeRates.add(exchangeRate);

        // Set Crypto to HKD
        exchangeRate = new ChannelDto().new ExchangeRate();
        exchangeRate.setFromCurr(entry.getKey());
        exchangeRate.setToCurr("HKD");
        exchangeRate.setRate(entry.getValue().getHkd());
        exchangeRates.add(exchangeRate);

        // Set USD to Crypto
        exchangeRate = new ChannelDto().new ExchangeRate();
        exchangeRate.setFromCurr("USD");
        exchangeRate.setToCurr(entry.getKey());
        exchangeRate.setRate(BigDecimal.ONE.divide(entry.getValue().getUsd(),
            new MathContext(6, RoundingMode.UP)));
        exchangeRates.add(exchangeRate);

        exchangeRate = new ChannelDto().new ExchangeRate();
        exchangeRate.setFromCurr("HKD");
        exchangeRate.setToCurr(entry.getKey());
        exchangeRate.setRate(BigDecimal.ONE.divide(entry.getValue().getHkd(),
            new MathContext(6, RoundingMode.UP)));
        exchangeRates.add(exchangeRate);

      }
      return exchangeRates;

    }

  public <T > T invoke(String baseUrl, 
      String serviceVers,
      String serviceUrl, HashMap<String, String> queryParms,
      Class<T> returnType) throws ApiException {
    try {
      UriComponentsBuilder url = UriComponentsBuilder.fromUriString(baseUrl)
          .pathSegment(serviceVers)
          .path(serviceUrl);

      for (Map.Entry<String, String> entry : queryParms.entrySet()) {
        url = url.queryParam(entry.getKey(), entry.getValue());
      }
      String urlString = url.build().toString();

      log.info("url={}", urlString);

      return restTemplate.getForObject(urlString, returnType);
    } catch (Exception e) {
      e.printStackTrace();
      throw new ApiException(80001, "Call coinGecko service fail");
    }
  }

  public <T extends CoinsMarkets> T[] invoke(String baseUrl,
      String serviceVers,
      String serviceUrl,
      Class<T[]> returnType) throws ApiException {
    try {
      UriComponentsBuilder url = UriComponentsBuilder.fromUriString(baseUrl)
          .pathSegment(serviceVers)
          .path(serviceUrl);

      String urlString = url.build().toString();

      log.info("url={}", urlString);

      return restTemplate.getForObject(urlString, returnType);
    } catch (Exception e) {
      e.printStackTrace();
      throw new ApiException(80001, "Call coinGecko service fail");
    }

  }

  public <K, V> Map<K, V> invoke2(String baseUrl,
      String serviceVers,
      String serviceUrl, HashMap<String, String> queryParms, 
      Class<Map<K, V>> returnType) throws ApiException {
    try {
      UriComponentsBuilder url = UriComponentsBuilder.fromUriString(baseUrl)
          .pathSegment(serviceVers)
          .path(serviceUrl);

        for(Map.Entry<String, String> entry : queryParms.entrySet()){
          url = url.queryParam(entry.getKey(), entry.getValue());
        }

      String urlString = url.build().toString();

      log.info("url={}", urlString);

      return restTemplate.getForObject(urlString, returnType);
    } catch (Exception e) {
      e.printStackTrace();
      throw new ApiException(80001, "Call coinGecko service fail");
    }
  }

}