package com.vtxlab.demo.goods.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vtxlab.demo.goods.entity.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long > {
  
}
