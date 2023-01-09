package com.vtxlab.demo.project.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.demo.project.exception.ApiException;
import com.vtxlab.demo.project.model.CoinsCurrencyMap;
import com.vtxlab.demo.project.model.dto.CoinsExchangeRate;
import com.vtxlab.demo.project.model.dto.CoinsMarkets;
import com.vtxlab.demo.project.service.ProjectService;
import com.vtxlab.demo.project.utils.CoinsApi;

@Service
public class ProjectServiceHolder implements ProjectService {

  @Autowired
  CoinsApi coinsApi;

  @Value("${coingecko.baseUrl}")
  String baseUrl;
  @Value("${coingecko.serviceVers}")
  String serviceVers;
  @Value("${coingecko.service.coins-markets.serviceUrl}")
  String serviceUrl;
  @Value("${coingecko.service.coins-markets.currency}")
  String vsCurrency;
  @Value("${coingecko.service.coins-markets.order}")
  String order;
  @Value("${coingecko.service.coins-markets.perPage}")
  String perPage;
  @Value("${coingecko.service.coins-markets.page}")
  String page;
  @Value("${coingecko.service.coins-markets.sparkline}")
  String sparkline; // boolean
  @Value("${coingecko.service.simple-price.serviceUrl}")
  String simplePriceUrl; 



  @Override
  public List<CoinsMarkets> getAllcoins() throws ApiException {

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("vs_currency", vsCurrency);
    hMap.put("order", order);
    hMap.put("per_page", perPage);
    hMap.put("page", page);
    hMap.put("sparkline", sparkline);

    return Arrays.asList(coinsApi.invoke(baseUrl, 
    serviceVers, serviceUrl, 
    hMap, CoinsMarkets[].class));
  };

  // https://api.coingecko.com/api/v3/simple/price?vs_currencies=usd,hkd&ids=bitcoin,ethereum,tether,dogecoin,ripple

  @Override
  public CoinsCurrencyMap getSimplePrices (List<String> cryptos, 
  List<String> currencies) throws ApiException, JsonProcessingException{

    String cryptoStr = cryptos.stream().collect(Collectors.joining(","));
    String currencyStr = currencies.stream().collect(Collectors.joining(","));

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("ids", cryptoStr);
    hMap.put("vs_currencies", currencyStr); 

    return coinsApi.invoke(baseUrl, serviceVers, simplePriceUrl, hMap, CoinsCurrencyMap.class);
  };




  } 


  

