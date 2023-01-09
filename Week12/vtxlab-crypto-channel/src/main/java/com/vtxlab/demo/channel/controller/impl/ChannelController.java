package com.vtxlab.demo.channel.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.channel.controller.ChannelOperation;
import com.vtxlab.demo.channel.exception.ApiException;
import com.vtxlab.demo.channel.model.dto.ChannelDto;
import com.vtxlab.demo.channel.service.OrchestrationService;

@RestController
@RequestMapping ( value =  "/crypto/channel/api/v1")
public class ChannelController implements ChannelOperation {
  
  @Autowired
  OrchestrationService orchestrationService;

  @Override
  public ChannelDto getWebExchangeRate( List <String> cryptos,
   List <String> currencies) throws ApiException{

    return orchestrationService.getExchangeRates(cryptos, currencies, "crypto-web");

   }


   @Override 
   public ChannelDto getAppExchangeRate( List<String> cryptos, 
    List <String> currencies) throws ApiException {
      return orchestrationService.getExchangeRates(cryptos, currencies, "crypto-app");


    }

}
