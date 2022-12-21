package com.vtxlab.demo.mysql.service;

import com.vtxlab.demo.mysql.entity.ChannelCoinMapping;

public interface CoinMappingService {

  ChannelCoinMapping save(Long id, ChannelCoinMapping channelCoinMapping);
  
}
