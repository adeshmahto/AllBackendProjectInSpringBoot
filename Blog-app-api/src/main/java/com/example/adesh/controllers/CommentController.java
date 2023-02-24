package com.example.adesh.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.adesh.payloads.ApiResponse;
import com.example.adesh.payloads.CommentDto;
import com.example.adesh.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	//create comment
	@PostMapping("post/{postId}/comments")
	public ResponseEntity<CommentDto>creatComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId){
		CommentDto com=this.commentService.createComment(commentDto, postId);
		
		return new ResponseEntity<CommentDto>(com,HttpStatus.CREATED);
		
	}
	
	//delete comment
	
    @DeleteMapping("comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {
    	this.commentService.deleteComment(commentId);
    	
    	return new ResponseEntity<ApiResponse> (new ApiResponse("Deleted succesfully!",true),HttpStatus.OK);
    	
    }

}
