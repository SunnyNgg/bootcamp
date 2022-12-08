package com.vtxlab.demo.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.vtxlab.demo.book.controller.BookStoreOperation;
import com.vtxlab.demo.book.controller.impl.BookStoreController;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.response.ApiResponse;
import com.vtxlab.demo.book.service.BookService;

@ExtendWith(SpringExtension.class) // @ Mock, MockBean, @ InjectMock
public class BookControllerUnitTest {

  @Mock
  BookService bookService;

  

  // @InjectMocks
  BookStoreOperation bookStoreOperation;
/* 
  @BeforeEach
  void setup(){
    bookStoreOperation = new BookStoreController(bookService);
    }

   @Test
   private void testControllerFindAllBooks(){

      when(bookService.findAllBooks()).thenReturn(List.of(new Book(), new Book()));

      ResponseEntity<ApiResponse<List<Book>>> books = bookStoreOperation.findAllBooks();

      assertThat(books.getBody().getData()).isNull();
      assertThat(books.getBody().getData()).isNull();
    }
  */
  
  @BeforeEach
  void setup() {
    bookStoreOperation = new BookStoreController(bookService);
  }

  private void testControllerFindAllBooks(List<Book> booksFromService, int size) {
    // Builder to build a book
    // given (Mock)
    when(bookService.findAllBooks()).thenReturn(booksFromService);
    // when 
    ResponseEntity<ApiResponse<List<Book>>>  books = bookStoreOperation.findAllBooks();
    // then
    assertThat(books.getBody().getData()).hasSize(size);
    //assertThat(books).hasSize(size);
  //  assertThat(books.get(0).getBookName()).isNull();
  //  assertThat(books.get(1).getBookName()).isNull();
  }

  @Test
  void testCaseForFindAllBooks() {
    testControllerFindAllBooks(List.of(new Book(), new Book()), 2);
    testControllerFindAllBooks(List.of(new Book()), 1);
    testControllerFindAllBooks(new ArrayList<>(), 0);
  }

  
  private void testFindBookById (Book book, Long id){
    when (bookService.findBook(anyLong())).thenReturn(book);

    ResponseEntity<ApiResponse<Book>> aBook = bookStoreOperation.findBook(id);

  if(book != null){
    assertThat(aBook.getBody().getData().getBookName()).isEqualTo(book.getBookName());
    assertThat(aBook.getBody().getData().getId()).isEqualTo(book.getId());
    assertThat(aBook.getBody().getData().getPublicDate()).isEqualTo(book.getPublicDate());
  } else{
    assertThat(aBook.getBody()).isEqualTo(null);
  }
}
  @Test 
  void testCaseForFindBookById(){
    testFindBookById(null, 1l);
    testFindBookById(
      new Book(1l, "Tommy's Books", LocalDate.of(2022, 6, 22), new Author()), 2l);
  }


  private void testCreateBook(Book book, Book returnBook){
    // Given
    when(bookService.saveBook(book)).thenReturn(returnBook);
    //when
    ResponseEntity <ApiResponse<Book>> newBook = bookStoreOperation.saveBook(book);
    //then
    if(returnBook != null){
      assertThat(returnBook.getBookName()).isEqualTo(newBook.getBody().getData().getBookName());
      assertThat(newBook.getStatusCode()).isEqualTo(HttpStatus.OK);
    }else{
      assertThat(newBook.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
  }

  @Test
  void testCaseForCreateBook(){
    Book book = new Book(1l, "Tommy's Books", LocalDate.of(2022, 6, 22), new Author());
  }

  private void testDeletedBookById(Long id, Book returnBook){
    
    when(bookService.deleteBook(anyLong())).thenReturn(returnBook);

    ResponseEntity <ApiResponse<Book>> controllerReturnBook = bookStoreOperation.deleteBook(id);

    if(returnBook != null){
      assertThat(controllerReturnBook.getBody().getData().getId()).isEqualTo(returnBook.getId());
      assertThat(controllerReturnBook.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }else{
      assertThat(controllerReturnBook.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
  }

  @Test
  void testCaseForDeleteBookById(){
    testDeletedBookById(1l , null);
    testDeletedBookById(2l,
    new Book(2l, "Tommy's Books", LocalDate.of(2022, 6, 22), new Author()));

  }



    
 
 
}