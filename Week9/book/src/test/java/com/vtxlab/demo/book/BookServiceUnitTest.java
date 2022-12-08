package com.vtxlab.demo.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.repository.BookRepository;
import com.vtxlab.demo.book.service.BookService;
import com.vtxlab.demo.book.service.impl.BookStoreService;

@ExtendWith(SpringExtension.class)
public class BookServiceUnitTest {

  @Mock
  BookRepository bookRepository;

  BookService bookService;

  @BeforeEach
  void setup(){
    bookService = new BookStoreService(bookRepository);
      
    }

    private void testServiceFindAllBooks(List<Book> booksFromRepository, int size){

      when(bookRepository.findAll()).thenReturn(booksFromRepository);

      List<Book> book = bookService.findAllBooks();

      assertThat(book).hasSize(size);
    }

    @Test
    void testCaseForFindAllBooks(){
      Book book1 =new Book (1l, "Tommy's Books", LocalDate.of(2022, 6, 22), new Author());
      testServiceFindAllBooks(List.of(book1), 1);
      Book book2 =new Book (2l, "Tommy's Books", LocalDate.of(2022, 6, 22), new Author());
      testServiceFindAllBooks(List.of(book2), 1);
    }

 

  }
  
