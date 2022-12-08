package com.vtxlab.demo.goods.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {

  @Id
  private Long id;

  @Column(name = "SUPPLIER_NAME")
  private String supplierName;

  @Column(name = "SUPPLIER_NAT")
  private String nationality;

  @OneToMany(mappedBy = "supplier",
  fetch = FetchType.LAZY,
  cascade = CascadeType.PERSIST,
  orphanRemoval = true)
  @JsonManagedReference
  private List<Goods> goods;

  
}
