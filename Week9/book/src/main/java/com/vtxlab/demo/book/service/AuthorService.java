package com.vtxlab.demo.book.service;

import java.util.List;
import com.vtxlab.demo.book.entity.Author;

public interface AuthorService {

  List<Author> findAllAuthors();
  

  List<Author> findAllAuthor();

  void deleteAuthor(Long id);
}
