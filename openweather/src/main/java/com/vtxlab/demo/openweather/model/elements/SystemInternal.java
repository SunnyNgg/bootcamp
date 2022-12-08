package com.vtxlab.demo.openweather.model.elements;

import java.io.Serializable;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemInternal implements Serializable{

  private Integer type;

  private Integer id;

  @JsonProperty("country")
  private String countryCode;

  @JsonProperty("sunrise")
  private BigDecimal sunriseTime;

  @JsonProperty("sunset")
  private BigDecimal sunsetTime;

  private BigDecimal message; 
  
}
