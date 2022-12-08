package com.vtxlab.demo.book.service.impl;


import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.exception.KeyExistException;
import com.vtxlab.demo.book.exception.KeyNotFoundException;
import com.vtxlab.demo.book.repository.BookRepository;
import com.vtxlab.demo.book.service.BookService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookStoreService implements BookService{

  @Autowired (required = true)
  BookRepository bookRepository;

  @Override
  public List<Book> findAllBooks(){
    return bookRepository.findAll();
  }

  @Override
  public Book findBook(Long id){
    return bookRepository.findById(id).orElse(null);
  }

  @Override
  public Book saveBook(Book book) throws KeyExistException{
    if(findBook(book.getId()) == null){
    return bookRepository.save(book);
  }
   throw new KeyExistException();
  }

  @Override
  public Book deleteBook(Long id) throws IllegalArgumentException{

    Book book = bookRepository.findById(id).orElse(null);
    if( book != null){
      bookRepository.deleteById(id);
      return book;
    }
    throw new KeyNotFoundException();
  }

  @Override //update
  public Book updateBookById(Book book, Long id ) {
      book.setId(id);
      return bookRepository.save(book);
      }

  @Override
  public Book updateBookName (Long id, String bookname){
    if (bookRepository.existsById(id)){
      Book books = bookRepository.findById(id).orElse(null);
      books.setBookName(bookname);
      return bookRepository.save(books);
    }
    return null;

  }

  }

  
  


