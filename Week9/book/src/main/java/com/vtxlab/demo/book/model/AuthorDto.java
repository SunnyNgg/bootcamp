package com.vtxlab.demo.book.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
  private Long id;

  private String authorName;

  private String nationlity;

  private List<BookDto> books;
  
}
