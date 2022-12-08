package com.vtxlab.demo.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.vtxlab.demo.book.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

  @Query(nativeQuery = true, //
      value = "delete from books b where b.author_id = :author_id")
  @Transactional
  @Modifying
  void deleteBooksByAuthorId(@Param("author_id") Long authorId);
}
