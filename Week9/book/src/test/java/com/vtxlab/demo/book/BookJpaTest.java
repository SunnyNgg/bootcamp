
package com.vtxlab.demo.book;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.repository.BookRepository;

/* 
@DataJpaTest
public class BookJpaTest {

  @Autowired
  BookRepository bookRepository;
  
  @BeforeEach
  void setup(){
    Book book = new Book(1l, "Sunny Book", LocalDate.of(2022, 10 ,1), new Author());
    Book book2 = new Book(2l, "Owie Book", LocalDate.of(2022, 10 ,1), new Author());
    bookRepository.save(book);
    bookRepository.save(book2);
  }

  @Test
  void testFindAll(){
    List<Book>

  }


}
*/