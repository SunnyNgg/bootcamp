package com.vtxlab.demo.project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.demo.project.exception.ApiException;
import com.vtxlab.demo.project.model.dto.ChannelDto;
import com.vtxlab.demo.project.model.dto.CoinsMarkets;

//@CrossOrigin
@RequestMapping(value = "/default")
public interface ProjectOperation {

  @GetMapping (value = "/coin/market")
  List <CoinsMarkets> getAllCoins () throws ApiException;

  @GetMapping (value = "/coingecko/simple-price")
  ChannelDto getSimplePrices (@RequestParam("coins") List<String> cryptos, 
  @RequestParam("currency") List<String> currencies)
  throws ApiException, JsonProcessingException; 
  
}
