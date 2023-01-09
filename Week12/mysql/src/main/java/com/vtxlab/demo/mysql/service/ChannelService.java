package com.vtxlab.demo.mysql.service;

import java.util.List;
import java.util.UUID;

import com.vtxlab.demo.mysql.entity.Channel;

public interface ChannelService {

  Channel getChannel(String sourceType, String tranType );

  Channel getChannel(String channelCode);

  List <Channel> getAllChannel();

  Channel updateChannel (Channel channel, Long channelId);
  
  Channel saveChannel (Channel channel, UUID uuid);

  Boolean isChannelCodeEmpty(String channelCode);

  Boolean isChannelCodeExist(String channelCode);

   Channel submitChannel (Channel channel, UUID uuid) throws IllegalArgumentException;

  void deleteAllChannel();
}
