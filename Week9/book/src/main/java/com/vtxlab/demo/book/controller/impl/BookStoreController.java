package com.vtxlab.demo.book.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.book.controller.BookStoreOperation;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.exception.KeyExistException;
import com.vtxlab.demo.book.response.ApiResponse;
import com.vtxlab.demo.book.service.BookService;
import lombok.AllArgsConstructor;
import lombok.Getter;

@RestController
@RequestMapping(value = "/api/v1/books")
@AllArgsConstructor
@Getter
public class BookStoreController implements BookStoreOperation {
/* 
  - /bookstore/book/id (Post method, with RequestBody, return nothing)
  - 201 https status if created (tips: ResponseEntity.created())
- /bookstore/book/id/{id} (Delete method, return Boolean)
  - 201 https status if book(s) is deleted (return true)
  - 400 https status if no book(s) is found (return false)
*/
  @Autowired //(required = true)
  BookService bookService;

  
  @Override
  public ResponseEntity <ApiResponse<List<Book>>> findAllBooks(){
    ApiResponse response = ApiResponse.<List<Book>>builder()
    .code(200)
    .message("All Book" )
    .data(bookService.findAllBooks())
    .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity <ApiResponse<Book>> findBook(Long id) throws IllegalArgumentException{
    if (bookService.findBook(id) != null){
      ApiResponse <Book>response = ApiResponse.<Book>builder()
    .code(200)
    .message("The Book is")
    .data(bookService.findBook(id))
    .build();
    return ResponseEntity.ok().body(response);
   }
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity <ApiResponse<Book>> saveBook(Book book)throws KeyExistException{
    ApiResponse <Book>response = ApiResponse.<Book>builder()
    .code(HttpStatus.OK.value()) //200
    .message(HttpStatus.OK.getReasonPhrase())
    .data(bookService.saveBook(book))
    .build();
    return ResponseEntity.created(null).body(response);
    } 
    

  @Override
  public ResponseEntity <ApiResponse<Book>> deleteBook(Long id) throws KeyExistException {
    // Book returnedbook = bookService.deleteBook(id);
    ApiResponse<Book> response = ApiResponse.<Book>builder()
    .code(HttpStatus.OK.value())
    .message("Delete Succes")
    .data(bookService.deleteBook(id))
    .build();
    if(bookService.deleteBook(id) == null){
      return ResponseEntity.badRequest().body(response);
    }

    return ResponseEntity.created(null).body(response);
  }

  @Override
  public ResponseEntity <ApiResponse<Book>> updateBookById (Book book, Long id) {
    ApiResponse <Book> response = ApiResponse.<Book>builder()
    .code(200)
    .message("updated")
    .data(bookService.updateBookById(book, id))
    .build();
    return ResponseEntity.created(null).body(response);
  }

  @Override
  public ResponseEntity<Book> updateBookByName ( Long id ,String bookname){
    Book updateBook = bookService.updateBookName(id, bookname);
    if (updateBook == null){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(updateBook);
  }

  }




