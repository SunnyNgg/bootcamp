package com.vtxlab.demo.project.model.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChannelDto {

  List<ExchangeRate> exchangeRate; 

  @Data
  public class ExchangeRate{
    private String fromCurr; 
    private String toCurr; 
    private BigDecimal rate ; 
  }
  
}
