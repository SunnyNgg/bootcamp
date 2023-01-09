package com.vtxlab.demo.vaildation.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiRespone<T> {

  int code; 

  String message; 

  T data; 

  
}
