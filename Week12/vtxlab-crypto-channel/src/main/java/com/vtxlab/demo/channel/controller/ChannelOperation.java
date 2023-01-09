package com.vtxlab.demo.channel.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.channel.exception.ApiException;
import com.vtxlab.demo.channel.model.dto.ChannelDto;

@RequestMapping (value = "default")
public interface ChannelOperation {

  @GetMapping (value = "/web/ex-rate")
  ChannelDto getWebExchangeRate(@RequestParam List <String> cryptos,
  @RequestParam List <String> currencies) throws ApiException;

  @GetMapping (value = "/app/ex-rate")
  ChannelDto getAppExchangeRate(@RequestParam List<String> cryptos, 
  @RequestParam List <String> currencies) throws ApiException;
  
  
}
