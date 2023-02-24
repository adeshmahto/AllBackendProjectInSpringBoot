package com.adesh.courseapp.services;

import java.util.List;

import com.adesh.courseapp.Dto.ProductDto;

public interface ProductService {
	
	ProductDto createProduct(ProductDto productDto);
	
	ProductDto updateProduct(ProductDto productDto,Integer productId);
	
	
	List<ProductDto> getAllProduct();
	
	ProductDto getProductById(Integer productId);
	
	void deleteProduct(Integer productId);
		
	
	
	
	
	

}
