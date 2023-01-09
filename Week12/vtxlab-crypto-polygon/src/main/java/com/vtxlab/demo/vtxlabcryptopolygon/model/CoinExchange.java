package com.vtxlab.demo.vtxlabcryptopolygon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CoinExchange implements Serializable {

   String ticker; 
   BigDecimal queryCount;
   BigDecimal resultsCount;
   Boolean adjusted;
  @JsonProperty(value = "results")
   List <ExchangeResult> results;
   String status;
   String requestId;
   BigDecimal count; 

  public String getTickerCryptoString(){
    return this.ticker.substring(2, 5); //X:BTCUSD -> BTC
  }

  public String getTickerCurrencyString(){
    return this.ticker.substring(5, 8); //X:BTCUSD -> USD
  }

@Data
@AllArgsConstructor
@NoArgsConstructor 
  public static class ExchangeResult implements Serializable {
    
    @JsonProperty (value = "T")
     String exchangeSymbol;

    @JsonProperty (value = "v")
    BigDecimal tradingVolume;

    @JsonProperty (value = "vw")
     BigDecimal volumeWeightedAveragePrice;

    @JsonProperty (value = "o")
     BigDecimal openPrice;

    @JsonProperty (value = "c")
     BigDecimal closePrice;

    @JsonProperty (value = "h")
     BigDecimal highestPrice;

    @JsonProperty (value = "l")
     BigDecimal  lowestPrice;

    @JsonProperty (value = "t")
     BigDecimal timestamp;

    @JsonProperty (value = "n")
     BigDecimal numberOfTransactions;
  
  
  }
}
