package com.vtxlab.demo.book.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.repository.AuthorRepository;
import com.vtxlab.demo.book.service.AuthorService;

@Service
public class AuthorServiceHolder implements AuthorService{

  @Autowired
  AuthorRepository authorRepository;

  @Override
  public List<Author> findAllAuthors(){
    return authorRepository.findAll();
  }

  @Override
  public List<Author> findAllAuthor(){
    return authorRepository.findAll();
  }

  private Boolean existById(Long id) {
    return authorRepository.existsById(id);
  }

  @Override
  public void deleteAuthor(Long id) {
    if (existById(id)) {
      authorRepository.deleteById(id);
    }
    return;
  }

  /*@Override
   * public List<AuthorDto> findAllAuthors
   * return authorRepository.findAll().stream(.map(e->{
   * List<BookDto> books = e.getBooks().stream()
   * .map(b -> modelmapper.map(b, BookDto.class)) //
          .collect(Collectors.toList());

      return new AuthorDto(e.getId(), e.getAuthorName(),
          e.getNationality(), books);
    }).collect(Collectors.toList());
  }
   * 
   */
  
}
