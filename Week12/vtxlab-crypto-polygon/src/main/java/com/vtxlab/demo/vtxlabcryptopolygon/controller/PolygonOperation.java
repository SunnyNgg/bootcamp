package com.vtxlab.demo.vtxlabcryptopolygon.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.vtxlabcryptopolygon.exception.ApiException;
import com.vtxlab.demo.vtxlabcryptopolygon.model.dto.ChannelDto;


@RequestMapping(value = "/default")
public interface PolygonOperation {

  @GetMapping(value = "/price")
  // return ChannelDto to customers 
  ChannelDto getExchangeRate(
    @RequestParam(value = "coins") List<String> cryptos,
    @RequestParam List<String> currencies) throws ApiException;



  
}
