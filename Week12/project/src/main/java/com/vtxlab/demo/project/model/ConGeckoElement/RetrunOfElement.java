package com.vtxlab.demo.project.model.ConGeckoElement;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RetrunOfElement {

  @JsonProperty("times")
  private BigDecimal times ; 

  @JsonProperty("currency")
  private String currency ; 

  @JsonProperty("percentage")
  private BigDecimal percentage ; 
  
}
