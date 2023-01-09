package com.vtxlab.demo.project.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.demo.project.controller.ProjectOperation;
import com.vtxlab.demo.project.exception.ApiException;
import com.vtxlab.demo.project.model.dto.ChannelDto;
import com.vtxlab.demo.project.model.dto.CoinsMarkets;
import com.vtxlab.demo.project.service.ProjectService;
import com.vtxlab.demo.project.utils.CoinsApi;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/crypto/api/v1")
@Slf4j
public class ProjectController implements ProjectOperation{

  @Autowired
  ProjectService projectService;

  @Override
  public List<CoinsMarkets> getAllCoins() throws ApiException{
    log.info("start Controller");
    // TODO Auto-generated method stub
    List<CoinsMarkets> coinsMarkets = projectService.getAllcoins();
    log.info("end Controller: {}", coinsMarkets );
    return coinsMarkets;
  }

  @Override
  public ChannelDto getSimplePrices(List<String> cryptos, List<String> currencies) throws ApiException, JsonProcessingException{

    return ChannelDto.builder()
      .exchangeRate(CoinsApi.map(projectService.getSimplePrices(cryptos, currencies)))
      .build();
  }



}
