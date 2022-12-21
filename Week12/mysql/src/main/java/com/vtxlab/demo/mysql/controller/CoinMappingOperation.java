package com.vtxlab.demo.mysql.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.mysql.entity.ChannelCoinMapping;

@RequestMapping(value = "/default")
public interface CoinMappingOperation {

  @PostMapping(value = "/channel/{id}/coinmap")
  ChannelCoinMapping saveCoinMapping(
    @PathVariable Long id,
    @RequestBody ChannelCoinMapping channelCoinMapping
  );
  
}
