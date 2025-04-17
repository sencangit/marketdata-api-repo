package com.finance.marketdata.restservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.marketdata.restservices.dao.EntityRepository;
import com.finance.marketdata.restservices.dao.ProductRepository;
import com.finance.marketdata.restservices.exception.ProductNotFoundException;
import com.finance.marketdata.restservices.models.EntityDetails;
import com.finance.marketdata.restservices.models.Product;

@Service
public class ProductDaoService {


	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private EntityRepository entityRepo;
	
	public Product findById(int product_id) {

		Product productObj = productRepo.findById(product_id)
				.orElseThrow(() -> new ProductNotFoundException("product_id: " + product_id + "--> not found."));
		
		return productObj;
	}

	public Product saveProduct(Product product, int entity_id) {
		
		 EntityDetails entityObj = entityRepo.findById(entity_id)
	                .orElseThrow(() -> new ProductNotFoundException("Entity id: " + entity_id + "--> not found"));
		 
		 product.setEntity(entityObj);
		 
		return productRepo.save(product);
	}

	public List<Product> findAllProducts() {
		return productRepo.findAll();
	}

	public void deleteById(int product_id) {
		productRepo.findById(product_id)
				.orElseThrow(() -> new ProductNotFoundException("product_id: " + product_id + "--> not found."));
		
		productRepo.deleteById(product_id);
	}

	public void deleteAllProducts() {
		productRepo.deleteAll();
	}

	public Product findProductByTicker(String ticker) {
		return productRepo.findBytickerName(ticker).stream().findFirst().orElse(null);
	}

}
