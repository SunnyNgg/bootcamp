package com.vtxlab.demo.post.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.model.PostDto;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

  /**
   * 
   * @param title
   * @return
   */
  List<Post> findByTitle(String title);

  //Like 
  List<Post> findByTitleContaining (String title);

  List<Post> findByTitleLike(String title);

// Native SQL - Specific DBMS
//MySQL
  @Query(nativeQuery = true, value = "select p.id, p.title, p.content from users u, posts p where u.user_id=p.user_id and u.user_id = :userId")
  List<Post> findPostByUserId(@Param ("userId")String userid);

  List <Post> findByTitleOrderByIdDesc(String title); 

// JPQL

  //List<Post> findbyTitleAndId(String title, Long id)
}
