package com.vtxlab.demo.book.service;

import java.util.List;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.exception.KeyExistException;
import com.vtxlab.demo.book.exception.KeyNotFoundException;
import lombok.Getter;



public interface BookService {

  List<Book> findAllBooks();

  Book findBook(Long id);

  Book saveBook(Book book) throws KeyExistException;

  Book deleteBook(Long id) throws KeyNotFoundException;

  Book updateBookById(Book book, Long id);

  Book updateBookName (Long id, String bookname);
  
}
