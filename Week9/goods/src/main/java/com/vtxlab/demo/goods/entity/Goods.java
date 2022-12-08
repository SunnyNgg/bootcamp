package com.vtxlab.demo.goods.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Goods {

  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "GOODS_NAME")
  private String goodName;

  @Column(name = "GOOD_SUPPLIER_ID")
  private Integer goodSupplierId;

  @Column(name = "PUBLIC_DATE")
  private LocalDate date;

  @ManyToOne (cascade = CascadeType.ALL)
  @JoinColumn (name = "GOODS_SUPPLIER_ID") 
  @JsonBackReference
  private Supplier supplier;

}
