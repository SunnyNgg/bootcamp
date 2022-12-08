package com.vtxlab.demo.greeting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.greeting.entity.Book;
import com.vtxlab.demo.greeting.repository.GreetingRepository;
import com.vtxlab.demo.greeting.service.GreetingService;




@Service
public class GreetingServiceHolder implements GreetingService{

  @Autowired
  GreetingRepository greetingRepository;

  @Override
  public String greeting(){
    return "Hello world";
  }

  @Override
  public List<Book> findAllBooks(){
    return greetingRepository.findAll();
  }

  @Override
  public Book findBooksById(Long id){
    return greetingRepository.findById(id).orElse(new Book());
  }


  
}
