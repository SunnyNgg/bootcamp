package com.vtxlab.demo.goods.service;

import java.util.List;
import com.vtxlab.demo.goods.entity.Goods;

public interface GoodsService {

  List<Goods> findAllGoods();

  Goods deleteGoodsById(Long id);

  Goods createGoods(Goods goods);

  Goods findGoodsById(Long id);
  
}
