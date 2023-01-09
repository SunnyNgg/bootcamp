package com.vtxlab.demo.vaildation.model;

import java.time.LocalDateTime;

import com.vtxlab.demo.vaildation.annotation.ValidTransNote;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Payment {

  @NotNull(message = "transDate is mandatory")
  private LocalDateTime transDate;

  @ValidTransNote
  private String transNote;

  @AssertTrue
  private boolean formBank; 

  @Size (min =10, max = 50, message = "Remark should ne within 10 to 50 characters")
  private String remarks;

  @Min(value = 1, message = "amount should not be less than 1 ")
  @Max(value = 10000, message = "amount should not be greater than 10000")
  private long amount;

  @Email (message = "Email should should be valid")
  private String email; 


  
}


