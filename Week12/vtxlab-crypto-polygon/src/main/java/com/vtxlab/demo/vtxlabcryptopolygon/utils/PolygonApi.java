package com.vtxlab.demo.vtxlabcryptopolygon.utils;

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

import com.vtxlab.demo.vtxlabcryptopolygon.exception.ApiException;
import com.vtxlab.demo.vtxlabcryptopolygon.model.CoinExchange;
import com.vtxlab.demo.vtxlabcryptopolygon.model.dto.ChannelDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PolygonApi {

  @Autowired
  RestTemplate restTemplate;

  public static List <ChannelDto.ExchangeRate> map(
    List<CoinExchange> coinExchanges) {

      List<ChannelDto.ExchangeRate> exchangeRates = new ArrayList<>(); 

      for (CoinExchange coinExchange : coinExchanges) {

        ChannelDto.ExchangeRate exchangeRate = new ChannelDto().buildExchangeRate();
        exchangeRate.setFromCurr(coinExchange.getTickerCryptoString()); // BTC
        exchangeRate.setToCurr(coinExchange.getTickerCurrencyString()); // USD
        exchangeRate.setRate(coinExchange.getResults().get(0).getHighestPrice()); //TBC
          exchangeRates.add(exchangeRate);
          // Set the rate for "Currency to Crypto"
        exchangeRate = new ChannelDto().buildExchangeRate();
        exchangeRate.setFromCurr(coinExchange.getTickerCurrencyString());
        exchangeRate.setToCurr(coinExchange.getTickerCryptoString());
        exchangeRate.setRate(
          BigDecimal.ONE.divide(
            coinExchange.getResults().get(0).getHighestPrice(),
            new MathContext(6, RoundingMode.HALF_UP)));
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
  throw new ApiException(80001, "Call Ploygon service fail");
}
}




  
}
