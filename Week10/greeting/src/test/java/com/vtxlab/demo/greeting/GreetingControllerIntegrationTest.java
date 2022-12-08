package com.vtxlab.demo.greeting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.demo.greeting.entity.Book;
import com.vtxlab.demo.greeting.repository.GreetingRepository;
import com.vtxlab.demo.greeting.service.GreetingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebMvcTest // Controller, @Configration, but not including Service, Repository so need to create the mockbean
// Start spring context, but with Controller related bean ONLY 
public class GreetingControllerIntegrationTest {

  @MockBean //Create a new bean to spring context
  GreetingService greetingService;

  @MockBean // Create a new bean to spring 
  GreetingRepository greetingRepository;

  @Autowired // Due to @WebMvcTest, the mockMvc Bean has been loaded to context
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  /* 
  @Test
  void testWebMvc() throws Exception{

    // Given
    Mockito.when(greetingService.greeting()).thenReturn("Hello world");
    // WHen 
   MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/v1/greeting");
      // execute the call
    ResultActions response =  mockMvc.perform(builder);
    StatusResultMatchers status = MockMvcResultMatchers.status();
  
    ResultMatcher statusOK = status.isOk(); // 200
    response.andExpect(statusOK);

    ContentResultMatchers content = MockMvcResultMatchers.content();
    ResultMatcher contentHelloworld = content.string("Hello worldd");
    response.andExpect(contentHelloworld);
  }
   */


  @Test
  void testWebMvc2() throws Exception{
    when(greetingService.greeting()).thenReturn("Hello world");
    mockMvc.perform(get("/api/v1/greeting"))
    .andExpect(status().isOk())
    .andExpect(content().string("Hello worldd"));
  }

  @Test
  void testFindAllBooks() throws Exception{
    Book book = new Book(1l,"Tommy's Books", LocalDate.of(2022, Month.JUNE, 22));
    List<Book> books = new ArrayList<>();
    books.add(book);

    when(greetingService.findAllBooks()).thenReturn(books);

    MvcResult result =  mockMvc.perform(get("/api/v1/books"))
      .andDo(print())
      .andExpect (status().isOk()).andReturn();
    String string = result.getResponse().getContentAsString();
    log.info(string);

   // ObjectMapper objectMapper = new ObjectMapper();
    List<Book> bookList = objectMapper.readValue(string, List.class);
    assertThat(bookList.size()).isEqualTo(1);
  }

  /* 
  @Test 
  void testFindBookById(Long id ) throws Exception{
    Book book = new Book(2l,"Tommy's Books", LocalDate.of(2022, Month.JUNE, 22));
    List<Book> books = new ArrayList<>();
    books.add(book);
    when(greetingService.findBooksById(id)).thenReturn(book);

    MvcResult result = mockMvc.perform(get("/api/v1/book/{id}"))
      .andDo(print())
      .andExpect(status().isOk()).andReturn();
    String string = result.getResponse().getContentAsString();
    log.info(string);

    ObjectMapper objectMapper = new ObjectMapper();
    List<Book> book2 = objectMapper.readValue(string, List.class);
    assertThat(book2.size()).isEqualTo(1);
  }
  */
}
