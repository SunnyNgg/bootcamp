package com.vtxlab.demo.book;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.demo.book.controller.impl.AuthorController;
import com.vtxlab.demo.book.controller.impl.BookStoreController;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.entity.Book;
import com.vtxlab.demo.book.repository.AuthorRepository;
import com.vtxlab.demo.book.repository.BookRepository;
import com.vtxlab.demo.book.response.ApiResponse;
import com.vtxlab.demo.book.service.AuthorService;
import com.vtxlab.demo.book.service.BookService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@WebMvcTest
public class BookControllerIntegrationTest {

  @MockBean
  BookService bookService;

  //@MockBean
  //BookRepository bookRepository;

  @MockBean
  AuthorController authorController;

  //@Autowired
  //BookStoreController bookStoreController;

  @Autowired
  MockMvc mockMvc;

  @Autowired 
  ObjectMapper objectMapper;

  @Test
  void testFindAllBooks() throws Exception{
    Book book = new Book(1l, "Tommy's Books", LocalDate.of(2022, Month.JUNE, 22), new Author() );

    when(bookService.findAllBooks()).thenReturn(List.of(book));

    MvcResult result =  mockMvc.perform(get("/api/v1/books/bookstore/books"))
      .andDo(print())
      .andExpect(status().isOk())
      //.andExpect(jsonPath("$[0].bookName").value("Tommy's Books"))
      .andReturn();

      String str = result.getResponse().getContentAsString();
      ApiResponse response = objectMapper.readValue(str, ApiResponse.class);
      List<Book> books = (List<Book>) response.getData();
      assertThat(books).hasSize(1);
  //  String string = result.getResponse().getContentAsString();
  //  log.info(string);

  // ObjectMapper objectMapper = new ObjectMapper();
  //  List<Book> bookList = objectMapper.readValue(string, List.class);
  //  assertThat(bookList).hasSize(1);
  }
  
}

