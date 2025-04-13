package com.finance.marketdata.restservices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.marketdata.restservices.exception.ProductNotFoundException;
import com.finance.marketdata.restservices.models.Product;

@Service
public class ProductDaoService {


	@Autowired
	private ProductRepository productRepo;

	public Optional<Product> findById(int product_id) {

		Optional<Product> productObj = productRepo.findById(product_id);

		if (productObj.isEmpty())
			throw new ProductNotFoundException("product_id: " + product_id);

		return productObj;
	}

	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	public List<Product> findAllProducts() {
		return productRepo.findAll();
	}

	public void deleteById(int product_id) {
		productRepo.deleteById(product_id);
	}

	public void deleteAllProducts() {
		productRepo.deleteAll();
	}

	public Product updateProductById(Product product) {
		return productRepo.save(product);
	}
	 



}
