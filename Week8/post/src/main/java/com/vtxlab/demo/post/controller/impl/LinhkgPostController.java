package com.vtxlab.demo.post.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.post.controller.PostOperation;
import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.model.PostDto;
import com.vtxlab.demo.post.model.UserDto;
import com.vtxlab.demo.post.response.ApiResponse;
import com.vtxlab.demo.post.service.PostService;

@RestController
@RequestMapping(value = "/linhkg/api/v1")
public class LinhkgPostController implements PostOperation{

  @Autowired
  PostService postService;

  @Override
  public List<Post> findAllPost(){
    return postService.findAllPost();
  }

  @Override
  public List<Post> saveAllPost(List<Post> posts){
    return postService.saveAllPost(posts);
  }

  @Override
  public Post findPostById(Long id){
    return postService.findPostById(id);
  }

  @Override
  public ResponseEntity<ApiResponse<Post>> savePost(Post post) 
  throws KeyExistException{
    ApiResponse <Post>response = ApiResponse.<Post>builder()
     .code(HttpStatus.OK.value())
     .message("OK")
     .data(postService.savePost(post))
     .build();
    return ResponseEntity.ok().body(response);
  }
    

  @Override
  public ResponseEntity<ApiResponse<Post>> deletePostById(Long id){
  ApiResponse<Post> response = ApiResponse.<Post>builder()
    .code(HttpStatus.OK.value())
    .message("Success Delete ")
    .data(postService.deletePostById(id))
    .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity <ApiResponse<List<Post>>> findByTitle(String title){
    ApiResponse<List<Post>> response = ApiResponse.<List<Post>>builder()
    .code(HttpStatus.OK.value())
    .message("Success!!!! ")
    .data(postService.findPostByTitle(title))
    .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity <ApiResponse<List<Post>>>findByTitleContaining (String title){
    ApiResponse<List<Post>> response = ApiResponse.<List<Post>>builder()
    .code(HttpStatus.OK.value())
    .message("Containing " + title)
    .data(postService.findByTitleContaining(title))
    .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<List<Post>>> findByTitleLike (String title){
    ApiResponse<List<Post>> response = ApiResponse.<List<Post>>builder()
    .code(HttpStatus.OK.value())
    .message(title + " had been found " )
    .data(postService.findByTitleLike(title))
    .build();
    return ResponseEntity.ok().body(response);
  }

  @Override
  public ResponseEntity<ApiResponse<UserDto>> findPostByUserId(String userId){
    List<PostDto> postDtos = postService.findPostByUserId(userId);
    UserDto userDto = UserDto.builder()
    .userId(userId)
    .posts(postDtos)
    .build();
    ApiResponse<UserDto> response = ApiResponse.<UserDto>builder()
    .code(HttpStatus.OK.value())
    .message(userId +  " had been found " )
    .data(userDto)
    .build();
    return ResponseEntity.ok().body(response);
  }

  }





