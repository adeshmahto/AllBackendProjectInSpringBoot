package com.example.adesh.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.adesh.entities.Category;
import com.example.adesh.exception.ResourceNotFoundException;
import com.example.adesh.payloads.CategoryDto;
import com.example.adesh.repositories.CategoryRepo;
import com.example.adesh.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
       // change to categoryDto to category
		Category cat =this.modelMapper.map(categoryDto, Category.class);
		
		// save the data using jparepository
		Category addedCat=this.categoryRepo.save(cat);
		
		//object which will change to , that object of the class
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
	  Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", " categoryid ", categoryId));
	
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
	    cat.setCategoryDescription(categoryDto.getCategoryTitle());
	   Category updatecat= this.categoryRepo.save(cat);
	   return this.modelMapper.map(updatecat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
		this.categoryRepo.delete(cat);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat =this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
	   return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
	List<Category> categories=	this.categoryRepo.findAll();
	//we have to change list of catogories into catogoryDto
	List<CategoryDto> catDtos=categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());

		return catDtos;
	}



	
}
