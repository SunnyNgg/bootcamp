package com.vtxlab.demo.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/default")
public interface GreetingOperation {

  @GetMapping(value = "/helloworld")
  public String getGreetingService();
  
}
