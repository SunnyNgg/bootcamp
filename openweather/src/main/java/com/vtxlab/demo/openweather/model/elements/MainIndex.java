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
public class MainIndex implements Serializable {

  @JsonProperty("temp")
  private BigDecimal temperature;

  @JsonProperty("feels_Like")
  private BigDecimal feelLikeTemerature;

  @JsonProperty("temp_min")
  private BigDecimal minTemperature;

  @JsonProperty("temp_max")
  private BigDecimal maxTemperature;

  private BigDecimal pressure;

  private BigDecimal humidity;

  
}
