package com.vtxlab.demo.greeting.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOOKS")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id;
 
  @Column(name = "BOOK_NAME")
  private String bookName;


  @Column(name = "PUBLIC_DATE", columnDefinition = "DATE")
  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
  private LocalDate publicDate;


  
}
