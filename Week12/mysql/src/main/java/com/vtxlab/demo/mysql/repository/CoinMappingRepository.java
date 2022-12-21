package com.vtxlab.demo.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtxlab.demo.mysql.entity.ChannelCoinMapping;

public interface CoinMappingRepository extends JpaRepository<ChannelCoinMapping, Long> {
  
}
