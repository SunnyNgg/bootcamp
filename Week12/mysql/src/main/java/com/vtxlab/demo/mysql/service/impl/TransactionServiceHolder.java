package com.vtxlab.demo.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.mysql.entity.ChannelTransaction;
import com.vtxlab.demo.mysql.repository.ChannelRepository;
import com.vtxlab.demo.mysql.repository.TransactionRepository;
import com.vtxlab.demo.mysql.service.TransactionService;

@Service
public class TransactionServiceHolder implements TransactionService {

  @Autowired
  TransactionRepository transactionRepository;

  @Autowired
  ChannelRepository channelRepository; 

  @Override
  public ChannelTransaction save (Long id, ChannelTransaction channelTransaction){

    return channelRepository.findById(id).map(channel ->{
      channelTransaction.setChannel(channel); 
      return transactionRepository.save(channelTransaction);
    }).orElse(null);
  }


  
}
