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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.adesh.courseapp.Dto.ProductDto;
import com.adesh.courseapp.services.FileService;
import com.adesh.courseapp.services.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	
	
	@PostMapping("/product")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
		return new ResponseEntity<ProductDto>(this.productService.createProduct(productDto),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/product/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto , @PathVariable Integer productId){
		return new ResponseEntity<ProductDto>(this.productService.updateProduct(productDto, productId),HttpStatus.OK);
		
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProduct(){
		return new ResponseEntity<List<ProductDto>>(this.productService.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping("/product/{productId}")
	public ResponseEntity<ProductDto> getPrductById(@PathVariable Integer productId){
		return new ResponseEntity<ProductDto>(this.productService.getProductById(productId),HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Integer productId){
		
	 try {
		 this.productService.deleteProduct(productId);
		 return new ResponseEntity<HttpStatus> (HttpStatus.OK);
	 }catch(Exception e) {
		 return new ResponseEntity<HttpStatus> (HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	}
	
// upload image
	
	@PostMapping("/product/image/upload/{productId}")
	public ResponseEntity<ProductDto> uploadPostImage(@RequestParam("image")MultipartFile image,
			@PathVariable Integer productId) throws IOException{
		//returning filename
	ProductDto postDto=this.productService.getProductById(productId);
	String fileName=this.fileService.uploadImage(path, image);
	postDto.setImageName(fileName);
	ProductDto updatePost=this.productService.updateProduct(postDto, productId);
	return new ResponseEntity<ProductDto>(updatePost,HttpStatus.OK);
	
	}
	
	
	//serve the image
	@GetMapping(value="product/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName")String imageName,
			HttpServletResponse response)throws IOException{
		
		InputStream resource=this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		
		StreamUtils.copy(resource, response.getOutputStream());
		
	}
	
	
	
}
