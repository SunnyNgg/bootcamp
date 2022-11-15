package com.vtxlab.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Product implements Comparable <Product> {

  private int productId; 
  private String productName;
  //private int Size;
  private String color;

  
  @Override 

  public int compareTo (Product o){
    return Integer.compare(o.getProductId(), this.productId);
  }
}
