package com.vtxlab.demo.vtxlabcryptopolygon.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.vtxlabcryptopolygon.controller.PolygonOperation;
import com.vtxlab.demo.vtxlabcryptopolygon.exception.ApiException;
import com.vtxlab.demo.vtxlabcryptopolygon.model.CoinExchange;
import com.vtxlab.demo.vtxlabcryptopolygon.model.dto.ChannelDto;
import com.vtxlab.demo.vtxlabcryptopolygon.service.PolygonService;
import com.vtxlab.demo.vtxlabcryptopolygon.utils.PolygonApi;

@RestController
@RequestMapping(value = "/crypto/polygon/api/v1")
public class PolygonController implements PolygonOperation{

  @Autowired
  PolygonService polygonService;

  @Override
  public ChannelDto getExchangeRate(List<String> cryptos, 
  List<String> currencies) throws ApiException{


    return ChannelDto.builder().exchangeRates(
      PolygonApi.map(polygonService.getCoinExchangeList(cryptos, currencies)))
      .build();
  }



  



  
}
