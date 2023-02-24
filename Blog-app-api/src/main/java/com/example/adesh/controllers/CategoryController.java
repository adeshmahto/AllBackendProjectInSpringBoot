package com.example.adesh.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.adesh.payloads.ApiResponse;
import com.example.adesh.payloads.CategoryDto;
import com.example.adesh.services.CategoryService;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
	
	@Autowired// we making object of catService which has the method which implement by the catservice imple                         
	private CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> creatCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createCategory=this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
		
	}
	
	//update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable  Integer catId){
		CategoryDto updateCategory=this.categoryService.updateCategory(categoryDto,catId);
		
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
		
	}
	
	//delete
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> DeleteCategory(@PathVariable  Integer catId){
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully !!",true),HttpStatus.OK);
		
	}
	
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable  Integer catId){
		
		CategoryDto cat=this.categoryService.getCategory(catId);
	
		return new ResponseEntity<CategoryDto>(cat,HttpStatus.OK);
		
		
	}
	
	//get all
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
	 List<CategoryDto> categories=this.categoryService.getCategories();
		return new ResponseEntity<List<CategoryDto>>(categories,HttpStatus.OK);
		
	}

	
}
