package com.vtxlab.demo.exercise.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Exercise3")
public class Exercise {
  @Id
 // @Column(name = "Id")
  private Long id;

  @Column(name = "Title")
  private String title;

  @Column(name = "Content")
  private String content;

  @Column(name = "userid")
  private String userId;
}
