package com.vtxlab.demo.mysql.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.mysql.entity.ChannelTransaction;

import jakarta.validation.Valid;

@RequestMapping(value = "/default")
public interface TransactionOperation {

  @PostMapping( value = "/channel/{id}/tran")
  ChannelTransaction saveTransaction(
    @PathVariable Long id,
    @Valid @RequestBody ChannelTransaction channelTransaction 
  );
  
}
