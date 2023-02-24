package com.example.adesh.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.adesh.entities.Category;
import com.example.adesh.entities.Post;
import com.example.adesh.entities.User;
import com.example.adesh.exception.ResourceNotFoundException;
import com.example.adesh.payloads.PostDto;
import com.example.adesh.payloads.PostResponse;
import com.example.adesh.repositories.CategoryRepo;
import com.example.adesh.repositories.PostRepo;
import com.example.adesh.repositories.UserRepo;
import com.example.adesh.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	//whenever we create post that time we put the user detail too and category
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user Id", userId));
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost=this.postRepo.save(post);
		
		PostDto NewpostDto=this.modelMapper.map(newPost, PostDto.class);
		return NewpostDto;
		
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		Post pot=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post Id",postId));
		pot.setImageName(postDto.getImageName());
		pot.setContent(postDto.getContent());
		pot.setTitle(postDto.getTitle());
		Post savePost=this.postRepo.save(pot);
		return this.modelMapper.map(savePost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post =this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
		this.postRepo.delete(post);
	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		Post pat=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
		return this.modelMapper.map(pat, PostDto.class);
	}

	@Override
	public PostResponse  getAllPost(Integer  pageNumber,Integer pageSize,String sortBy,String sortDir) {
		Sort sort=(sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
	
	//paging and sorting->
		Pageable p=PageRequest.of(pageNumber, pageSize, sort);
	//storing all posts in a page wise which has so many method which used to paging
		Page<Post> pagePost=this.postRepo.findAll(p); 
		
		//list will have only content
		List<Post> allPosts=pagePost.getContent();
		List<PostDto> postDtos=allPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse=new PostResponse();
		
	    postResponse.setContent(postDtos);
	    postResponse.setPageNumber(pagePost.getNumber());
	    postResponse.setPageSize(pagePost.getSize());
	    postResponse.setTotalElements(pagePost.getTotalElements());
	    postResponse.setTotalpages(pagePost.getTotalPages());
	    
	    postResponse.setLastPage(pagePost.isLast());
	    
	    return postResponse;
	    
	}
//  check below code
	@Override
	public PostResponse getPostsByCategory(Integer categoryId,Integer  pageNumber,Integer pageSize) {
		Category cat =this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "category Id", categoryId));
		Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<Post>posts =(Page<Post>)this.postRepo.findByCategory(cat);
		
		List<Post> allposts=posts.getContent();
		List<PostDto> postDtos=	allposts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse pr=new PostResponse();
		pr.setContent(postDtos);
		pr.setPageNumber(posts.getNumber());
		pr.setPageSize(posts.getSize());
		pr.setTotalElements(posts.getTotalElements());
		pr.setTotalpages(posts.getTotalPages());
		pr.setLastPage(posts.isLast());
		return pr;
	}

	@Override
	public PostResponse getPostsByUser(Integer userId,Integer pageNumber,Integer pageSize) {
	  User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","user id",userId));
	  Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<Post>posts =(Page<Post>) this.postRepo.findByUser(user);
		List<Post> allposts=posts.getContent();
		List<PostDto> postDtos=	allposts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse pr=new PostResponse();
		pr.setContent(postDtos);
		pr.setPageNumber(posts.getNumber());
		pr.setPageSize(posts.getSize());
		pr.setTotalElements(posts.getTotalElements());
		pr.setTotalpages(posts.getTotalPages());
		pr.setLastPage(posts.isLast());
		return pr;
			
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		List<Post>posts=this.postRepo.searchByTitleContaining("%"+keyword+"%");
		List<PostDto> postDto=posts.stream().map((post)-> this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}

	
}
