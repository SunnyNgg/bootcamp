package com.vtxlab.demo.channel.service;

import java.util.List;

import com.vtxlab.demo.channel.exception.ApiException;
import com.vtxlab.demo.channel.model.dto.ChannelDto;

public interface ThirdPartyService2 {

  ChannelDto gethThirdPartyExchangeRates(List<String> cryptos,
    List<String> currencies) throws ApiException; 
  
}
