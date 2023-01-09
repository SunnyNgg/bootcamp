package com.vtxlab.demo.vtxlabcryptopolygon.service;

import java.util.List;

import com.vtxlab.demo.vtxlabcryptopolygon.exception.ApiException;
import com.vtxlab.demo.vtxlabcryptopolygon.model.CoinExchange;

public interface PolygonService {

  List<CoinExchange> getCoinExchangeList(List<String> cryptos, 
  List<String> currencies) throws ApiException;
  //Loop cryptos to invoke Polygon API


}
