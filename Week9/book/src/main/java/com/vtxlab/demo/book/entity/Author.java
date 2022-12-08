package com.vtxlab.demo.book.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUTHORS")
public class Author {

  @Id
  //@Column(name = "AUTHOR_ID")
  private Long id; 

  @Column(name = "AUTHOR_NAME")
  private String authorName;

  @Column(name = "AUTHOR_NAT")
  private String nationality;


  
  @OneToMany(mappedBy = "author", 
  fetch = FetchType.LAZY, // default LAZY
  cascade = CascadeType.PERSIST, 
  orphanRemoval = true)
  @JsonIgnoreProperties({"author"})
  private List<Book> books;
  
  public Author(Long id, String anthorName, String nationality){
    this.id = id;
    this.authorName = anthorName;
    this.nationality = nationality;
  }
}
