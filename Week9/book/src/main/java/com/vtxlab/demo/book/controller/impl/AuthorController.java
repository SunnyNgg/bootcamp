package com.vtxlab.demo.book.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.book.controller.AuthorOperation;
import com.vtxlab.demo.book.entity.Author;
import com.vtxlab.demo.book.model.AuthorDto;
import com.vtxlab.demo.book.model.BookDto;
import com.vtxlab.demo.book.service.AuthorService;
import lombok.Getter;

@RestController
@Getter
@RequestMapping( "/api/v1")
public class AuthorController implements AuthorOperation{

  @Autowired 
  AuthorService authorService;

  
  @Autowired 
  ModelMapper modelMapper;
  
  @Override // using the @JsonManagedReference and @JsonBackReference in entity 
  public ResponseEntity <List<Author>> findAllAuthor(){
  List<Author> authors =authorService.findAllAuthor();
  return ResponseEntity.ok().body(authors);
  }


    @Override
    public ResponseEntity <List<AuthorDto>> findAllAuthors(){
    List<AuthorDto> authorDtos = authorService.findAllAuthors().stream().map(
    e -> {List<BookDto> books = e.getBooks().stream()
    .map(b -> modelMapper.map(b, BookDto.class))
    .collect(Collectors.toList());

    return new AuthorDto(e.getId(),e.getAuthorName(),
    e.getNationality(), books);
    }).collect(Collectors.toList());
    
    return ResponseEntity.ok().body(authorDtos);
    }
   
    @Override
    public ResponseEntity<Void> deleteById(Long id) {
      authorService.deleteAuthor(id);
      return ResponseEntity.ok().build();
    }
    
}
