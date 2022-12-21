package com.vtxlab.demo.mysql.service;

import java.util.List;
import java.util.UUID;

import com.vtxlab.demo.mysql.entity.Channel;

public interface ChannelService {

  Channel getChannel(String sourceType, String tranType );

  List <Channel> getAllChannel();

  Channel updateChannel (Channel channel, Long channelId);
  
  Channel saveChannel (Channel channel, UUID uuid);

  //Boolean isChannelCodeEmpty(String channelCode);

  public Channel submitChannel (Channel channel, UUID uuid) throws IllegalArgumentException;



  void deleteAllChannel();
}
