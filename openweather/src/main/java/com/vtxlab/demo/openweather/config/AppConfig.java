package com.vtxlab.demo.openweather.config;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.vtxlab.demo.openweather.response.Alert;

@Configuration
public class AppConfig {

  @Bean
  public ModelMapper modelMapper(){
    return new ModelMapper() ;
  } 

  @Bean(name = "alerts")
  public List <Alert> alerts(){
    return new ArrayList<>();
  }




  
}
