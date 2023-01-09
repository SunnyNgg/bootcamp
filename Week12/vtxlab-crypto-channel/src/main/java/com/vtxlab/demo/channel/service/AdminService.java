package com.vtxlab.demo.channel.service;

import java.util.List;

import com.vtxlab.demo.channel.exception.ApiException;
import com.vtxlab.demo.channel.model.Channel;
import com.vtxlab.demo.channel.model.ChannelCoinMapping;

public interface AdminService {

  Channel getChannelBySourceAppAndTranType(String SourceApp, String tranType)
  throws ApiException;

  List <ChannelCoinMapping> getCoinMappings (Long id)
    throws ApiException; 

  Channel getChannelByChannelCode(String channelCode)
    throws ApiException; 
  
}
