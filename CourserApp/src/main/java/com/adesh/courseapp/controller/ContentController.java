package com.adesh.courseapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adesh.courseapp.entities.Content;
import com.adesh.courseapp.services.ContentService;
import com.adesh.courseapp.services.FileService;



@RestController
public class ContentController {
	
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private FileService fileService;
	
	// path where the image will be stored
	@Value("${project.image}")
	private String path;
	
	// create Content
	
	@PostMapping("/contents")
	public ResponseEntity<Content> creatContent(@RequestBody Content content){
		
	Content createcontent=this.contentService.creatContent(content);
	
	return new ResponseEntity<Content>(createcontent,HttpStatus.CREATED);
		
		
	}
	// getting all the content
	@CrossOrigin
	@GetMapping("/contents")
	public ResponseEntity<List<Content>> getAllContent(){
		
		return new ResponseEntity<List<Content>>(this.contentService.getAllContent(),HttpStatus.OK);
		
		
	}
	//get single content
	@GetMapping("/content/{contentId}")
	public ResponseEntity<Content> getSingleContent(@PathVariable Integer contentId){
		
		return new ResponseEntity<Content>(this.contentService.getSingleContent(contentId),HttpStatus.OK);
		
	}
	//delete content
	@DeleteMapping("/content/{contentId}")
	public ResponseEntity<HttpStatus> deleteContent(@PathVariable Integer contentId){
		try {
			this.contentService.deleteContent(contentId);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//update
	@PutMapping("/content/{contentId}")
	public ResponseEntity<Content> updateContent(@RequestBody Content content ,@PathVariable Integer contentId){
		
		return new ResponseEntity<Content>(this.contentService.updateContent(content, contentId),HttpStatus.OK);
	}
	
	//post image upload
		@PostMapping("/content/image/upload/{contentId}")
		public ResponseEntity<Content> uploadPostImage(@RequestParam("image")MultipartFile image,
				@PathVariable Integer contentId) throws IOException{
			//returning filename
		Content postDto=this.contentService.getSingleContent(contentId);
		String fileName=this.fileService.uploadImage(path, image);
		postDto.setImageName(fileName);
		Content updatePost=this.contentService.updateContent(postDto, contentId);
		return new ResponseEntity<Content>(updatePost,HttpStatus.OK);
		
		}
		//method to serve files
		@GetMapping(value="content/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
		public void downloadImage(@PathVariable("imageName")String imageName,
				HttpServletResponse response)throws IOException{
			
			InputStream resource=this.fileService.getResource(path, imageName);
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			
			StreamUtils.copy(resource, response.getOutputStream());
			
		}
		
	
	
	

}
