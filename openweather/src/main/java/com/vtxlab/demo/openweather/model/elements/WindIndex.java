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
public class WindIndex implements Serializable{

     @JsonProperty("speed")
     private BigDecimal windSpeed;

     @JsonProperty("deg")
     private BigDecimal windDegree;

  
}
