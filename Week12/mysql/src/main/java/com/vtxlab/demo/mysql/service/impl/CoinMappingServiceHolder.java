package com.vtxlab.demo.mysql.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtxlab.demo.mysql.entity.ChannelCoinMapping;
import com.vtxlab.demo.mysql.repository.ChannelRepository;
import com.vtxlab.demo.mysql.repository.CoinMappingRepository;
import com.vtxlab.demo.mysql.service.CoinMappingService;

@Service
public class CoinMappingServiceHolder implements CoinMappingService{

  @Autowired
  CoinMappingRepository coinMappingRepository; 

  @Autowired 
  ChannelRepository channelRepository; 

  @Override
  public ChannelCoinMapping save(Long id, ChannelCoinMapping channelCoinMapping){

    return channelRepository.findById(id).map(channel ->{
      channelCoinMapping.setChannel(channel); 
      return coinMappingRepository.save(channelCoinMapping);
    }).orElse(null);
  }

 /*  Channel channel = channelRepository.findById(id).orElse(null);
    ChannelCoinMapping.setChannel(channel);
    return coinMappingRepository.save(channelCoinMapping);
   */

   /*

    public static List<Integer> convert (List<String> strings){
      return strings.stream().map(str -> Integer.valueOf(str))
      .collect(Collectors.toList());
    }

    * public List<Integer> test (List<String> strings){

      Integer integer = 0; 
      List<Integer> integer = new ArrayList<>();
      for(String str : strings){
        integer = Integer.valueOf(str);
        integers.add(integer);
      }
      return integers;
    }

  
    */

 

  
}
