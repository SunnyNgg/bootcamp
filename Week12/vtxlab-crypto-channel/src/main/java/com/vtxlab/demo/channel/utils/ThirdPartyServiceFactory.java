package com.vtxlab.demo.channel.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.vtxlab.demo.channel.service.ThirdPartyService;
import com.vtxlab.demo.channel.service.ThirdPartyService2;

@Component
public class ThirdPartyServiceFactory {

  @Autowired 
  @Qualifier("coingeckoService")
  ThirdPartyService2 coingeckoService;

  @Autowired
  @Qualifier("polygonService")
  ThirdPartyService2 polygonService; 

  public ThirdPartyService2 produceThridPartyService(String sourceApp){
    return switch (sourceApp){
      case "crypto-web" -> coingeckoService;
      case "crypto-app" -> polygonService;
      default -> null;
    };
  }

  
}
