package com.vtxlab.demo.channel.service.impl;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.channel.exception.ApiException;
import com.vtxlab.demo.channel.model.Channel;
import com.vtxlab.demo.channel.model.ChannelTransaction;
import com.vtxlab.demo.channel.model.dto.ChannelDto;
import com.vtxlab.demo.channel.service.AdminService;
import com.vtxlab.demo.channel.service.OrchestrationService;
import com.vtxlab.demo.channel.service.ThirdPartyService;
import com.vtxlab.demo.channel.service.ThirdPartyService2;
import com.vtxlab.demo.channel.utils.ThirdPartyServiceFactory;

@Service
public class OrchestrationServiceHolder implements OrchestrationService {
  
  @Autowired
  AdminService adminService;

  @Autowired
  ThirdPartyService thirdPartyService;

  @Autowired
  ThirdPartyServiceFactory thirdPartyServiceFactory; 

  final static String TRAN_TYPE_EX_RATE = "ex-rate";

  @Override
  public ChannelDto getExchangeRates(List<String> cryptos,
      List<String> currencies, String sourceApp) throws ApiException {
    // Invoke Admin Service
    Channel channel = adminService.getChannelBySourceAppAndTranType(sourceApp,
        TRAN_TYPE_EX_RATE);

    // Invoke Third Party API Service
    Predicate<ChannelTransaction> sourceAppCheck = e -> sourceApp
        .equals(e.getSourceApp());
    Predicate<ChannelTransaction> tranTypeCheck = e -> TRAN_TYPE_EX_RATE
        .equals(e.getTranType());

        // Get Channel Transaction for URL mapping
    ChannelTransaction channelTran = channel.getCoinTrans().stream()
        .filter(sourceAppCheck.and(tranTypeCheck)).findFirst()
        .orElse(null);

      // Get Channel Coin Mapping for coin code conversion 
    List<String> coinIds  = channel.getCoinMaps().stream()
    .map(e -> e.getCoinId()).collect(Collectors.toList());

        // Step 3 : Invoke Thrid Party API Service
      return  thirdPartyService.getThirdPartyExchangeRates(
        coinIds, // [bitcoin, tether, etherum]
        currencies,
        channel.getChannelUrl(),
        channelTran.getDomainVersion(),
        channelTran.getDomainUrl());
  }

  // Design Approach 2 : Assume all third API service mapping coded in channel- service 

  @Override
  public ChannelDto getExchangeRates2(List<String> cryptos,
  List<String> currencies, String sourceApp) throws ApiException{

    ThirdPartyService2 thirdPartyService = thirdPartyServiceFactory
    .produceThridPartyService(sourceApp);

    return thirdPartyService.gethThirdPartyExchangeRates(cryptos, currencies);
    
  }


}
