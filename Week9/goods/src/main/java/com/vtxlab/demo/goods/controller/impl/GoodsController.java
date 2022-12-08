package com.vtxlab.demo.goods.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.goods.controller.GoodsOperation;
import com.vtxlab.demo.goods.entity.Goods;
import com.vtxlab.demo.goods.service.impl.GoodsServiceHolder;

@RestController
@RequestMapping (value = "/api/v1")
public class GoodsController implements GoodsOperation{

  @Autowired
  GoodsServiceHolder goodsServiceHolder;

  @Override
  public ResponseEntity <List<Goods>> findAllGoods(){
    return ResponseEntity.ok().body(goodsServiceHolder.findAllGoods());
  }

  @Override
  public ResponseEntity <Goods> deleteGoodsByID(Long id){
    Goods goods = goodsServiceHolder.deleteGoodsById(id);
    return ResponseEntity.ok().body(goods);
  }
  @Override
  public  ResponseEntity<Goods> createGoods(Goods goods){
    Goods good = goodsServiceHolder.createGoods(goods);
      return ResponseEntity.created(null).body(good);
    }

    @Override
    public ResponseEntity <Goods> findGoodsById(Long id){
      return ResponseEntity.ok().body(goodsServiceHolder.findGoodsById(id));
    }
    

  }


  

