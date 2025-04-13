package com.finance.marketdata.restservices.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.marketdata.restservices.dao.ProductDaoService;
import com.finance.marketdata.restservices.models.Product;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/v1/products")
public class MarketDataController {

	
	private Logger log = LoggerFactory.getLogger(MarketDataController.class);
	
	@Autowired
	private ProductDaoService productService;
	
	
	@GetMapping("")
	public List<Product> getProducts() {
		log.debug("getProducts called.. ");
		return productService.findAllProducts();
	}
	
	@GetMapping("/{product_id}")
	public Optional<Product> getProductData(@PathVariable int product_id) {
		log.debug("getProductData called with product_id {}.. ", product_id);
		return productService.findById(product_id);
		
	}
	
	@PostMapping("")
	public Product saveProductData(@Valid @RequestBody Product product) {
		
		return productService.saveProduct(product);
	}
	
	
	@PutMapping("")
	public Product updateProductData(@Valid @RequestBody Product product) {

		return productService.updateProductById(product);
	}
	
	
	@DeleteMapping("/{product_id}")
	public void deleteProductData(@PathVariable int product_id) {
		log.debug("deleteProductData called with product_id {}.. ", product_id);
		
		productService.deleteById(product_id);
		
	}
	
	@DeleteMapping("")
	public void deleteAllProducts() {
		log.debug("deleteAllProducts called.. ");
		productService.deleteAllProducts();
		
	}



}
