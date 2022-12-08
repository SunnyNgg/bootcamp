package com.vtxlab.demo.book.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOKS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter

public class Book  {

  public Book(Long a, String b, LocalDate c){}


  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id;
 
  @Column(name = "BOOK_NAME")
  private String bookName;


  @Column(name = "PUBLIC_DATE")
  private LocalDate publicDate;

  @ManyToOne (cascade = CascadeType.ALL)
  @JoinColumn(name = "AUTHOR_ID")
  @JsonBackReference
  private Author author;

  
}
