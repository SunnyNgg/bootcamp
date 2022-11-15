package com.vtxlab.app.enums;

import java.util.Arrays;
import java.util.Optional;

enum OrderStatus {
  ORDERRED(1),
  PAID(2),
  READY_TO_SHIP(3),
  DELIVERED(4),
  UNKNOW(99),
  ;

  private int code;

  OrderStatus(){}

  private OrderStatus(int code){
    this.code= code; 
  }
  
  public static OrderStatus fromCode(int code ){
    for(OrderStatus o : OrderStatus.values()){
      if (o.code == code){
        return o;
      }
    }
    return OrderStatus.UNKNOW; 
  }

  public static OrderStatus fromCode2(int code){
    return Arrays.stream(OrderStatus.values())
                 .filter(e -> e.code == code )
                 .findFirst().orElse(OrderStatus.UNKNOW);
  }
   public static Optional <OrderStatus> fromCode3(int code) {
    return Arrays.stream(OrderStatus.values())
                .filter(e -> e.code == code)
                .findFirst();
                //.orElseThrow(()->new NullPointerException());
   }



  
}
