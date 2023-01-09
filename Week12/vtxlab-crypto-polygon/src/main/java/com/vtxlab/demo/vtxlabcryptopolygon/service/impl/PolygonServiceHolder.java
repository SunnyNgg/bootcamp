package com.vtxlab.demo.vtxlabcryptopolygon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.vtxlabcryptopolygon.exception.ApiException;
import com.vtxlab.demo.vtxlabcryptopolygon.model.CoinExchange;
import com.vtxlab.demo.vtxlabcryptopolygon.service.PolygonService;
import com.vtxlab.demo.vtxlabcryptopolygon.utils.PolygonApi;

@Service
public class PolygonServiceHolder implements PolygonService{
  
  // https://api.polygon.io/v2/aggs/ticker/X:BTCUSD/prev?adjusted=true&apiKey=c11pu_AYPwalmRWBsRtBU6oxl2pBxdz5
  @Autowired
  PolygonApi polygonApi; 

  @Value("${polygon.baseUrl}")
  String baseUrl;
  @Value("${polygon.serviceVers}")
  String serviceVers;
  @Value("${polygon.service.previous.serviceUrl}")
  String serviceUrl;
  @Value("${polygon.apiKey}")
  String apiKey;
  @Value("${polygon.service.previous.adjusted}")
  String adjusted;


  @Override
  // cryptos: BTC ETH USDT
  // currencies: USD JPY
  // -> BTCUSD, ETHUSD, USDTUSD, BTCJPY, ETHJPY, USDTJPY
  public List<CoinExchange> getCoinExchangeList(List<String> cryptos, 
  List<String> currencies ) throws ApiException{

    //Loop cryptos to invoke Polygon API
    List<CoinExchange> coinExchanges = new ArrayList<>();
    for (String coin : cryptos) {
      for(String curr : currencies) {
        coinExchanges.add(getCoinExchange(coin, curr));
      }
    }
    return coinExchanges;
    }

    private CoinExchange getCoinExchange(String crypto, String currency ) 
    throws ApiException{

    // Originally, serviceUrl = ticker/{ticker}/prev
    // To replace {ticker} by X:BTCUSD ("X:" + crypto + currency)
    // As a result, ticker/X:BTCUSD/prev
    String updatedServiceUrl = serviceUrl.replace("{ticker}"
    , "X:" + crypto + currency);

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("adjusted", adjusted);
    hMap.put("apiKey", apiKey);



    return polygonApi.invoke(baseUrl, 
    serviceVers, updatedServiceUrl, 
    hMap, CoinExchange.class);
  }
}

