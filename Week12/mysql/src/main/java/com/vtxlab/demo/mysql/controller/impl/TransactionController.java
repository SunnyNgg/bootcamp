package com.vtxlab.demo.mysql.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.mysql.controller.TransactionOperation;
import com.vtxlab.demo.mysql.entity.ChannelTransaction;
import com.vtxlab.demo.mysql.service.TransactionService;
@RestController
@RequestMapping(value = "/crypto/admin/api/v1")
public class TransactionController implements TransactionOperation{

  @Autowired
  TransactionService transactionService;
  

  @Override
  public ChannelTransaction saveTransaction( Long id, ChannelTransaction channelTransaction){

    return transactionService.save(id, channelTransaction);
    
}
}
