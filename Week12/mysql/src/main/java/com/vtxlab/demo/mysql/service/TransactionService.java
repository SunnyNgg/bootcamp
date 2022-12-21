package com.vtxlab.demo.mysql.service;

import com.vtxlab.demo.mysql.entity.ChannelTransaction;

public interface TransactionService {

  
  ChannelTransaction save (Long id, ChannelTransaction channelTransaction);
}
