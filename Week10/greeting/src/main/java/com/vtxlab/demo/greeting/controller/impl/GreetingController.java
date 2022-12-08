package com.vtxlab.demo.greeting.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.entity.Book;
import com.vtxlab.demo.greeting.service.GreetingService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class GreetingController implements GreetingOperation{

  // GreetingController(greetringService){}

  @Autowired
  GreetingService greetingService;

  @Override
  public String greeting(){
    return greetingService.greeting() + "d";
  }

  @Override
  public List<Book> findAllBooks(){
    return greetingService.findAllBooks();
  }

  @Override
  public Book findBooksById(Long id){
    return greetingService.findBooksById(id);
  }
  
}
