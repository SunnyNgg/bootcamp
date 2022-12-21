package com.vtxlab.demo.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vtxlab.demo.mysql.entity.ChannelTransaction;

public interface TransactionRepository extends JpaRepository<ChannelTransaction, Long>{
  
}
