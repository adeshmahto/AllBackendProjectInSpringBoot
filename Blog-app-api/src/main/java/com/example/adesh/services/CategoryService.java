package com.example.adesh.services;

import java.util.List;

import com.example.adesh.payloads.CategoryDto;

public interface CategoryService {
	
	//create
    CategoryDto createCategory(CategoryDto categoryDto);
     //update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
    //delete
    void deleteCategory(Integer categoryId);
    //get 
    CategoryDto getCategory(Integer Id);
    //get all
    List<CategoryDto> getCategories();
    

}
