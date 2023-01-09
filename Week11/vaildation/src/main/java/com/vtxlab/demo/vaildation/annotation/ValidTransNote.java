package com.vtxlab.demo.vaildation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.vtxlab.demo.vaildation.annotation.vaildator.TransNoteVaildator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


  @Target ({ ElementType.FIELD})
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Constraint(validatedBy = TransNoteVaildator.class)
  public @interface ValidTransNote{
    String message() default "Transaction Note is not valid";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};

  }
  
