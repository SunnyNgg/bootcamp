package com.vtxlab.demo.post.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.exception.KeyNotFoundException;
import com.vtxlab.demo.post.model.PostDto;
import com.vtxlab.demo.post.repository.PostRepository;
import com.vtxlab.demo.post.service.PostService;
import lombok.extern.slf4j.Slf4j;

@Slf4j // = system.out.println
@Service
public class LihkgPostService implements PostService {

  @Autowired(required = true) // new PostRepository();
  PostRepository postRepository; // object reference

  @Override
  public List<Post> findAllPost(){
    return postRepository.findAll();

  }
@Override
  public List<Post> saveAllPost(List<Post> posts){
    return postRepository.saveAll(posts);
  }

  @Override 
  public Post findPostById(Long id){
    return postRepository.findById(id).orElse(null);
  }

  @Override
  public Post savePost(Post post) throws KeyExistException{
    if(findPostById(post.getId()) == null){
      return postRepository.save(post);
    }
    throw new KeyExistException();
  }

  @Override
  public Post deletePostById(Long id) throws IllegalArgumentException{
    Post post = postRepository.findById(id).orElse(null);
    if ( post != null){
      postRepository.deleteById(id);
      return post;
    }
    throw new KeyNotFoundException();
  }

  @Override
  public List<Post> findPostByTitle(String title){
    return postRepository.findByTitle(title);
  }

  @Override
  public List<Post> findByTitleContaining (String title){
    return postRepository.findByTitleContaining(title);
  }
  @Override
  public List<Post> findByTitleLike(String title){
    return postRepository.findByTitleLike(title);
  }

  @Override
  public List<PostDto> findPostByUserId(String userid){
    List<PostDto> postDtos = new ArrayList<>();
    // return List<Post>, and convert to List<PostDto>
     postRepository.findPostByUserId(userid).forEach(e ->{
      PostDto postDto = PostDto.builder()
      .content(e.getContent())
      .title(e.getTitle())
      .build();
      //add the dto to list
      log.info("Start to proceed, postDto: {}", postDto.toString() );
      postDtos.add(postDto);
     });
     return postDtos;
  }
  
}
