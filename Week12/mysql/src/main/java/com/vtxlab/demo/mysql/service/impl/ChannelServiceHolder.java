package com.vtxlab.demo.mysql.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.mysql.entity.Channel;
import com.vtxlab.demo.mysql.repository.ChannelRepository;
import com.vtxlab.demo.mysql.service.ChannelService;


@Service
public class ChannelServiceHolder implements ChannelService {
   
  @Autowired
  ChannelRepository channelRepository;

  @Autowired
  RedisTemplate <String, Channel> redisTemplate; 

  @Override
  public Channel getChannel(String sourceType, String tranType ) {
    return channelRepository.findByChannelTransactionsSourceAppAndChannelTransactionsTranType(sourceType, tranType); 
                           
  }

  @Override
  public Channel getChannel(String channelCode){
    return channelRepository.findByChannelCode(channelCode);
  }

  @Override
  public Channel updateChannel (Channel channel, Long channelId){
    return channelRepository.findById(channelId).map(chl ->{
      chl.setChannelCode(channel.getChannelCode());
      chl.setChannelCode(channel.getChannelUrl());
      chl.setLastUpdDate(channel.getLastUpdDate() == null ? LocalDateTime.now()
      : channel.getLastUpdDate()); 
      return channelRepository.save(chl);
    }).orElse(null); 
    }
 //   @Override
 //   public Channel updateChannelById (Channel channel, Long channelId){
  //  if(channelRepository.existsById(id)){
   // return channelRepository.save(channel);
  //  }
  //    return null; 
   // }

  @Override
  public Channel saveChannel (Channel channel, UUID uuid){
    System.out.println("checkpoint: "+ uuid);
    String redisKey = "crypto:admin:post:channel:uuid" + uuid;
    // crypto:admin:post:channel:uuid: a72b97cb-7a6c-47ab-9778-8042ecca25ce
    if (redisTemplate.opsForValue().get(redisKey) != null){
      return null;
    }
    Channel savedChannel = channelRepository.save(channel);
    redisTemplate.opsForValue().set(redisKey, savedChannel, Duration.ofDays(1));
    return savedChannel;
  }



  private Boolean isChannelCodeEmpty2(String channelCode){
    return channelRepository.existsByChannelCode(channelCode);

  }

  @Override
  public Channel submitChannel (Channel channel, UUID uuid) throws IllegalArgumentException{

   if (Boolean.valueOf(false).equals(isChannelCodeEmpty2(channel.getChannelCode()))){ //<<<
    return saveChannel(channel, uuid);
   }
   throw new IllegalArgumentException(); 
  }


  @Override
  public List<Channel> getAllChannel() {
    return channelRepository.findAll();
  }

  @Override 
  public void deleteAllChannel(){
    channelRepository.deleteAll();
  }

  @Override
  public Boolean isChannelCodeExist(String channelCode) {
    // TODO Auto-generated method stub
    return channelRepository.existsByChannelCode(channelCode);
  }

  @Override
  public Boolean isChannelCodeEmpty(String channelCode) {
    // TODO Auto-generated method stub
    return  channelRepository.existsByChannelCode(channelCode);
  }
}
