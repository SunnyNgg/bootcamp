package com.vtxlab.demo.mysql.controller.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.mysql.controller.ChannelOperation;
import com.vtxlab.demo.mysql.entity.Channel;
import com.vtxlab.demo.mysql.service.ChannelService;

@RestController
@RequestMapping(value = "/crypto/admin/api/v1")
public class ChannelController implements ChannelOperation{

  @Autowired
  ChannelService channelService;
  //http://localhost:8087/crpyto/api/v1/admin?tranType=ex-rate&sourceApp=crypto-web

  
  @Override
  public Channel getChannel(String sourceApp, String tranType ){
    return channelService.getChannel(sourceApp, tranType);

  }

  @Override
  public List<Channel> getAllChannel(){
    return channelService.getAllChannel();
  }


  @Override
  public ResponseEntity<Channel> saveChannel(Channel channel, UUID uuid){
    Channel savedChannel = channelService.saveChannel(channel, uuid);
    if (savedChannel == null) {
      return ResponseEntity.badRequest().build();
    }
     return ResponseEntity.ok().body(savedChannel);
  }


  @Override
  public Channel updateChannel (Channel channel, Long id){
    return channelService.updateChannel(channel, id);
  }


  @Override
  public Channel submitChannel ( Channel channel, UUID uuid){
    System.out.println("second I wanna know: "+ uuid);
    return channelService.submitChannel(channel, uuid);
  }



  @Override
  public void deleteAllChannel(){
     channelService.deleteAllChannel();
  }

}
