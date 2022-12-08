package com.vtxlab.demo.book;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.vtxlab.demo.book.controller.BookStoreOperation;
import com.vtxlab.demo.book.controller.impl.BookStoreController;
import com.vtxlab.demo.book.repository.BookRepository;

@SpringBootTest
@AutoConfigureMockMvc
class BookApplicationTests {

	@Autowired
	BookStoreOperation bookStoreOperation;

	@Autowired
	BookStoreController bookStoreController;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	MockMvc mockMvc;



	@Test
	void contextLoads() {

		Assertions.assertThat(bookRepository).isNotNull();
		Assertions.assertThat(bookStoreController).isNotNull();
		Assertions.assertThat(bookStoreOperation).isNotNull();
	}

	/* 
	@Test
	void testIntegrationForFindAllBooks() throws Exception{
		mockMvc.perform(get("/bookstore/books"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	*/
}

