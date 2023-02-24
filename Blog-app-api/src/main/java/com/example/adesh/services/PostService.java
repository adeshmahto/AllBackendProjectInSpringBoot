package com.example.adesh.services;

import java.util.List;



import com.example.adesh.entities.Post;
import com.example.adesh.payloads.PostDto;
import com.example.adesh.payloads.PostResponse;


public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto ,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	
     void deletePost(Integer postId);
     
     //get post
     PostDto getPostById(Integer postId);
     
     //get posts
     PostResponse getAllPost(Integer  pageNumber,Integer pageSize,String sortBy,String sortDir);
     
     //get all post by category
     
     PostResponse getPostsByCategory(Integer categoryId,Integer  pageNumber,Integer pageSize);
     
     //get all post by user
     PostResponse getPostsByUser(Integer userId,Integer  pageNumber,Integer pageSize);
     
     //get by search
     
     List<PostDto> searchPosts(String keyword);

}
