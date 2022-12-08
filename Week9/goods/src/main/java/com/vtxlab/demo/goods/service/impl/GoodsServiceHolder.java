package com.vtxlab.demo.goods.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.goods.entity.Goods;
import com.vtxlab.demo.goods.repository.GoodsRepository;
import com.vtxlab.demo.goods.service.GoodsService;

@Service
public class GoodsServiceHolder implements GoodsService {

  @Autowired
  GoodsRepository goodsRepository;

  @Override
  public List<Goods> findAllGoods(){
    return goodsRepository.findAll();
  }

  @Override
  public Goods deleteGoodsById(Long id){
    Goods goods = goodsRepository.findById(id).orElse(null);
    if (goods != null){
      goodsRepository.deleteById(id);
      return goods;
    }
    return null;
  }

  @Override
  public Goods findGoodsById(Long id){
    return goodsRepository.findById(id).orElse(null);
  }


  @Override
  public Goods createGoods(Goods goods){
    if(findGoodsById(goods.getId()) == null ){
      return goodsRepository.save(goods);

    }
    return null;

  }

  
}
