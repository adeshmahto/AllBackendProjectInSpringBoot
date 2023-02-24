package com.adesh.courseapp.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adesh.courseapp.Dto.ProductDto;
import com.adesh.courseapp.dao.ProductDao;
import com.adesh.courseapp.entities.Product;
import com.adesh.courseapp.exception.ResourceNotFoundException;
import com.adesh.courseapp.services.ProductService;


@Service

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductDao productDao;

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		
		Product product=this.modelMapper.map(productDto, Product.class);
		return this.modelMapper.map(this.productDao.save(product), ProductDto.class);
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto,Integer productId) {
		
		
		Product product =this.productDao.findById(productId).orElseThrow(()->new ResourceNotFoundException("product","id",productId));
		
		product.setImageName(productDto.getImageName());
		product.setPrice(productDto.getPrice());
		return this.modelMapper.map(this.productDao.save(product), ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> products=this.productDao.findAll();
		
		List<ProductDto> productDto=products.stream().map((pd)-> this.modelMapper.map(pd, ProductDto.class)).collect(Collectors.toList());
		return productDto;
	}

	@Override
	public ProductDto getProductById(Integer productId) {
		
		Product product=this.productDao.findById(productId).orElseThrow(()->new ResourceNotFoundException("product","id",productId));
		return this.modelMapper.map(product, ProductDto.class);
	}

	@Override
	public void deleteProduct(Integer productId) {
		Product product=this.productDao.findById(productId).orElseThrow(()->new ResourceNotFoundException("product","id",productId));
	
		this.productDao.delete(product);
		
	}

}
