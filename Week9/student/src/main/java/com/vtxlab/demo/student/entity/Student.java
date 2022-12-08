package com.vtxlab.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

@Entity
@Table (name = "Students")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {

  @Id
  private Long Id;

  @Column(name = "height")
  private Double height;

  @Column(name = "name")
  private String name;  
  
}
