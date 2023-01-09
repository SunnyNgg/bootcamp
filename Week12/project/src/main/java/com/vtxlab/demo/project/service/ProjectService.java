package com.vtxlab.demo.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.demo.project.exception.ApiException;
import com.vtxlab.demo.project.model.CoinsCurrency;
import com.vtxlab.demo.project.model.dto.CoinsExchangeRate;
import com.vtxlab.demo.project.model.dto.CoinsMarkets;

public interface ProjectService {

  List<CoinsMarkets> getAllcoins() throws ApiException; 

  HashMap <String, CoinsCurrency> getSimplePrices (List<String> cryptos, List<String> currencies) throws ApiException, JsonProcessingException; 
  
}
