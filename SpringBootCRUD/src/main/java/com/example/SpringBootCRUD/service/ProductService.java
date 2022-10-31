package com.example.SpringBootCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootCRUD.entity.Product;
import com.example.SpringBootCRUD.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	public List<Product> getListProducts(){
		return productRepository.findAll();
	}
	public Optional<Product> findProductByID(Long producId){
		return productRepository.findById(producId);
	}
}
