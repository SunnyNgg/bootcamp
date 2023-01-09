package com.vtxlab.demo.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtxlab.demo.mysql.entity.ChannelCoinMapping;

public interface CoinMappingRepository extends JpaRepository<ChannelCoinMapping, Long> {

  List<ChannelCoinMapping> findByChannelId(Long id );
  
}
