package com.vtxlab.demo.openweather.model.elements;

import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate implements Serializable{

  @JsonProperty("lan")
  private BigDecimal latitude;
  
  @JsonProperty("lon")
  private BigDecimal longitude;


  
}
