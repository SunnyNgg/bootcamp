package com.vtxlab.demo.channel.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.channel.exception.ApiException;
import com.vtxlab.demo.channel.model.ChannelCoinMapping;
import com.vtxlab.demo.channel.model.dto.ChannelDto;
import com.vtxlab.demo.channel.service.AdminService;
import com.vtxlab.demo.channel.service.ThirdPartyService2;
import com.vtxlab.demo.channel.utils.ChannelApi;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoingeckoService implements ThirdPartyService2 {

  @Autowired
  AdminService adminService;

  @Autowired
  ChannelApi channelApi; 


  final static String TRAN_TYPE_EX_RATE = "ex-rate";
  final static String CHANNEL_CODE_COINGECKO = "coingecko";

  @Value("${service.coingecko.baseUrl}")
  String baseUrl;
  @Value("${service.coingecko.serviceVers}")
  String serviceVers;
  @Value("${service.coingecko.serviceUrl}")
  String serviceUrl;

  @Override
  public ChannelDto gethThirdPartyExchangeRates(List<String> cryptos,
  List<String> currencies) throws ApiException{

    List<ChannelCoinMapping> coinMappings = adminService
    .getChannelByChannelCode(CHANNEL_CODE_COINGECKO)
    .getCoinMaps();

    List<String> coins = cryptos.stream()
    .map(coin -> {
      return coinMappings.stream()
      .filter(m -> m.getCoinCode() == coin)
      .map(e -> e.getCoinId()).toString();
    }).collect(Collectors.toList());

    log.info("coin={}", coins);
    String concatCoins = String.join(",", coins);
    String concatCurrencies = String.join(",", currencies);

    HashMap<String, String> hMap = new HashMap<>();
    hMap.put("coins", concatCoins);
    hMap.put("currency", concatCurrencies);

    return channelApi.invoke(baseUrl, 
    serviceUrl, serviceUrl, hMap, ChannelDto.class);


  }


}
