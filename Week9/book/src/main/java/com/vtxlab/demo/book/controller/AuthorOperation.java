package com.vtxlab.demo.book.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.model.AuthorDto;

@RequestMapping(value = "/default")
public interface AuthorOperation {

  @GetMapping(value = "/author")
  ResponseEntity <List<AuthorDto>> findAllAuthors();

  @GetMapping(value = "/authors")
  ResponseEntity <List<Author>> findAllAuthor();

  @DeleteMapping(value = "/authors/id/{id}")
  ResponseEntity<Void> deleteById(@PathVariable Long id);
  
}
