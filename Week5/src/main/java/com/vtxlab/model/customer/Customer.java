package com.vtxlab.model.customer;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString



public class Customer implements Comparable<Customer> {

  private int id; 
  private String name;
  private LocalDate joinDate;

  @Override 
  public int compareTo(Customer c){

    return Integer.compare(c.getId(), this.id);
    
  }


}

  
