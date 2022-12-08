package com.vtxlab.demo.openweather.model.elements;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rain implements Serializable {

  
  private BigDecimal oneHour;
  
}
