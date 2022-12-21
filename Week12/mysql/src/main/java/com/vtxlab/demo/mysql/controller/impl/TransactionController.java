package com.vtxlab.demo.mysql.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.mysql.controller.TransactionOperation;
import com.vtxlab.demo.mysql.entity.ChannelTransaction;
import com.vtxlab.demo.mysql.service.impl.TransactionServiceHolder;

@RestController
@RequestMapping(value = "/crypto/admin/api/v1")
public class TransactionController implements TransactionOperation{

  @Autowired
  TransactionServiceHolder transactionServiceHolder;
  

  @Override
  public ChannelTransaction saveTransaction( Long id, ChannelTransaction channelTransaction){

    return transactionServiceHolder.save(id, channelTransaction);
    
}
}
