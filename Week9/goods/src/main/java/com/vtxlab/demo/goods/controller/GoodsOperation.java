package com.vtxlab.demo.goods.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtxlab.demo.goods.entity.Goods;

@RequestMapping(value = "/default")
public interface GoodsOperation {
  
  @GetMapping(value = "/goods")
  ResponseEntity <List<Goods>> findAllGoods();

  @DeleteMapping(value = "/good/{id}")
  ResponseEntity <Goods> deleteGoodsByID(@PathVariable Long id);

  @PostMapping(value = "/good/id")
  ResponseEntity <Goods> createGoods(@RequestBody Goods goods);

  @GetMapping(value ="/goods/{id}")
  ResponseEntity <Goods> findGoodsById(@PathVariable Long id);

}
