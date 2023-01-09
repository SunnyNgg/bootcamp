package com.vtxlab.demo.project.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinsExchangeRate extends CoinsMarkets implements Serializable {

  private Rates rates;  


@Data
@NoArgsConstructor
@AllArgsConstructor
  public class Rates {
    Map<String, Conis> map = new HashMap<String, Conis>();
  }



  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public class Conis {
  private String name;
  private String unit;
  private BigDecimal value;
  private String type;

}

}
