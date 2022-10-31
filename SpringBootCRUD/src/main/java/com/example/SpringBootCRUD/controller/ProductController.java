package com.example.SpringBootCRUD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootCRUD.entity.Product;
import com.example.SpringBootCRUD.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
	public ResponseEntity createProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.createProduct(product));
	}
	@PostMapping("/get-list")
	public ResponseEntity getList() {
		return ResponseEntity.ok(productService.getListProducts());
	}
}
