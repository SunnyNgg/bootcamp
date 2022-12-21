package com.vtxlab.demo.mysql.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vtxlab.demo.mysql.entity.Channel;

import jakarta.validation.Valid;

@RequestMapping(value = "/default")
public interface ChannelOperation {
//http://localhost:8087/crpyto/api/v1/admin?tranType=ex-rate&sourceApp=crypto-web

 @GetMapping(value = "/channel")
  Channel getChannel(@RequestParam String sourceApp, @RequestParam String tranType );

  @GetMapping(value = "/channels")
  List<Channel> getAllChannel(); 

  @PostMapping (value = "/channel")
  ResponseEntity<Channel> saveChannel (@Valid @RequestBody Channel channel, @RequestParam UUID uuid ); 

  @PutMapping(value = "/channel/id/{id}")
  Channel updateChannel (@RequestBody Channel channel, @PathVariable Long id);

  @PostMapping (value = "/channel-submit")
  Channel submitChannel (@Valid @RequestBody Channel channel,@RequestParam UUID uuid);


   @DeleteMapping(value = "/channels")
   void deleteAllChannel();

}


