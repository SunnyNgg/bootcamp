package com.vtxlab.demo.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.demo.book.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
  
}
