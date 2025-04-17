package com.finance.marketdata.restservices.controller;

import java.util.List;

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

import com.finance.marketdata.restservices.models.Product;
import com.finance.marketdata.restservices.service.ProductDaoService;

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
	public Product getProductData(@PathVariable int product_id) {
		log.debug("getProductData called with product_id {}.. ", product_id);
		return productService.findById(product_id);
		
	}
	
	@PostMapping("/entity/{entity_id}")
	public Product saveProductData(@Valid @RequestBody Product product, @PathVariable int entity_id) {
		return productService.saveProduct(product, entity_id);
	}
	
	
	@PutMapping("/entity/{entity_id}")
	public Product updateProductData(@Valid @RequestBody Product product, @PathVariable int entity_id) {
		return productService.saveProduct(product, entity_id);
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
