package com.vtxlab.demo.mysql.controller.impl;

import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.mysql.controller.CoinMappingOperation;
import com.vtxlab.demo.mysql.entity.ChannelCoinMapping;
import com.vtxlab.demo.mysql.service.impl.CoinMappingServiceHolder;

@RestController
@RequestMapping(value = "/crypto/admin/api/v1")
public class CoinMappingContorller implements CoinMappingOperation{

  @Autowired 
  CoinMappingServiceHolder coinMappingServiceHolder;

  @Override
  public ChannelCoinMapping saveCoinMapping(Long id, ChannelCoinMapping channelCoinMapping){
    return coinMappingServiceHolder.save(id, channelCoinMapping);
  }

  
}
