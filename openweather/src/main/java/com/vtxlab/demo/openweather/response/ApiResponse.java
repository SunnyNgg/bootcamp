package com.vtxlab.demo.openweather.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
/*
 * !HttpStaus. Instead, its internal response code, controlled by enum.
 */
  private Integer code;

   /**
   * !HttpsStatus message.
   * Instead, its internal response message, controlled by enum.
   */

  private String msg;

   /**
   * Able to map any type, but not primitive.
   */

  private T data; 

   /**
   * Includes warning and error.
   */

  private List<Alert> alerts;

  
}
