package com.vtxlab.demo.post.service;

import java.util.List;
import com.vtxlab.demo.post.entity.Post;
import com.vtxlab.demo.post.exception.KeyExistException;
import com.vtxlab.demo.post.model.PostDto;

public interface PostService {
  List<Post> findAllPost();

  List<Post> saveAllPost(List<Post> posts);

  Post findPostById(Long id);

  Post savePost(Post post) throws KeyExistException;

  Post deletePostById(Long id);

  List<Post> findPostByTitle(String title);

  List<Post> findByTitleContaining (String title);

  List<Post> findByTitleLike(String title);

  List<PostDto> findPostByUserId(String userid);
}
