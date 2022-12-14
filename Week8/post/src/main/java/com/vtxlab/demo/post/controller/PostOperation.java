package com.vtxlab.demo.post.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.model.UserDto;
import com.vtxlab.demo.post.response.ApiResponse;

@RequestMapping(value = "/default")
public interface PostOperation {

  @GetMapping(value = "/posts")
  List<Post> findAllPost();


  @PostMapping(value = "/posts")
  List<Post> saveAllPost(@RequestBody List<Post> posts);

  @PostMapping(value = "/post")
  ResponseEntity <ApiResponse<Post>> savePost(@RequestBody Post post) 
  throws Exception;

  @GetMapping(value = "/posts/id/{id}")
  Post findPostById (@PathVariable Long id);

  @DeleteMapping(value = "/post/id/{id}")
  ResponseEntity <ApiResponse<Post>> deletePostById(@PathVariable Long id )
  throws Exception; 

  @GetMapping(value = "/post/title/{title}")
  ResponseEntity <ApiResponse<List<Post>>>findByTitle(@PathVariable String title)
  throws Exception;

  @GetMapping(value = "/post/contain/{title}")
  ResponseEntity <ApiResponse<List<Post>>>findByTitleContaining (@PathVariable String title)
  throws Exception;

  @GetMapping(value = "/post/like/{title}")
  ResponseEntity <ApiResponse<List<Post>>>findByTitleLike (@PathVariable String title);

  @GetMapping(value = "/post/userid/{userId}")
  ResponseEntity<ApiResponse<UserDto>> findPostByUserId(@PathVariable String userId);
  
}
