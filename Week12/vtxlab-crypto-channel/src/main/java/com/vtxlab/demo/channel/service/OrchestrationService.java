package com.vtxlab.demo.channel.service;

import java.util.List;

import com.vtxlab.demo.channel.exception.ApiException;
import com.vtxlab.demo.channel.model.dto.ChannelDto;

public interface OrchestrationService {

  ChannelDto getExchangeRates(List<String> cryptos,
      List<String> currencies, String sourceApp) throws ApiException;

      ChannelDto getExchangeRates2 (List<String> cryptos,
      List<String> currencies, String sourceApp) throws ApiException;

}
