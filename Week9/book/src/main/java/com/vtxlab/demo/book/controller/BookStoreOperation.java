package com.vtxlab.demo.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.exception.KeyExistException;
import com.vtxlab.demo.book.response.ApiResponse;
import lombok.AllArgsConstructor;


@RequestMapping(value = "/default")
public interface BookStoreOperation {

  @GetMapping(value = "/bookstore/books")
  ResponseEntity <ApiResponse<List<Book>>> findAllBooks();

  @GetMapping(value =  "/bookstore/book/id/{id}")
  ResponseEntity <ApiResponse<Book>> findBook(@PathVariable Long id) throws IllegalArgumentException;

  @PostMapping(value = "/bookstore/book/id")
  ResponseEntity <ApiResponse<Book>> saveBook(@RequestBody Book book) throws KeyExistException;


  @DeleteMapping(value = "/bookstore/book/id/{id}")
  ResponseEntity <ApiResponse<Book>> deleteBook (@PathVariable Long id) throws IllegalArgumentException;

  @PutMapping(value = "/bookstore/book/id/{id}")
  ResponseEntity <ApiResponse<Book>> updateBookById (@RequestBody Book book, @PathVariable Long id);

  @PatchMapping(value = "/bookstore/book/id/{id}/name/{bookname}")
  ResponseEntity<Book> updateBookByName (@PathVariable Long id, @PathVariable String bookname);

  }

 

  
  

  

