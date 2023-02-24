package com.example.adesh.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adesh.entities.Comment;
import com.example.adesh.entities.Post;
import com.example.adesh.exception.ResourceNotFoundException;
import com.example.adesh.payloads.CommentDto;
import com.example.adesh.repositories.CommentRepo;
import com.example.adesh.repositories.PostRepo;
import com.example.adesh.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		//from the post id we take it all the object of post 
		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));
		Comment comment=this.modelMapper.map(commentDto,Comment.class);
		comment.setPost(post);
		Comment createdPost=this.commentRepo.save(comment);
		return this.modelMapper.map(createdPost, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
//		this.commentRepo.deleteById(commentId);
		
	Comment comment=this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Post","post id",commentId));
		this.commentRepo.delete(comment);
	}

}
