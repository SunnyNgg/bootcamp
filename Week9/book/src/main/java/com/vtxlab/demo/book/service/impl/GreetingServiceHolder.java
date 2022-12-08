package com.vtxlab.demo.book.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demo.book.service.GreetingService;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class GreetingServiceHolder implements GreetingService {

  @Value("${rest.greeting.baseUrl}")
  String baseUrl;

  @Value("${rest.greeting.serviceVers}")
  String serviceVers;

  @Value("${rest.greeting.serviceUrl}")
  String serviceUrl;

  @Override
  public String greeting(){
    //return "hello world"
    // call another result
    //String baseUrl= "http://localhost:8092";
   // String serviceVers = "api/v1";
   // String serviceUrl = "greeting";


    // Call another service to get result
    String url = UriComponentsBuilder.fromUriString(baseUrl)
    .pathSegment(serviceVers)
    .path(serviceUrl)
    .build()
    //.encode()
    .toString();

    log.info("url={}", url);

    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(url, String.class);

  }

  
}
