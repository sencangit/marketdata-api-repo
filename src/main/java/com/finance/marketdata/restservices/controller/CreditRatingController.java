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

import com.finance.marketdata.restservices.models.CreditRating;
import com.finance.marketdata.restservices.models.Product;
import com.finance.marketdata.restservices.service.CreditRatingService;
import com.finance.marketdata.restservices.service.ProductDaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/ratings")
public class CreditRatingController {
	
private Logger log = LoggerFactory.getLogger(CreditRatingController.class);
	
	@Autowired
	private CreditRatingService ratingService;
	
	@Autowired
	private ProductDaoService prodService;
	
	
	@GetMapping("")
	public List<CreditRating> getRatings() {
		log.debug("getRatings called.. ");
		return ratingService.findAllRatings();
	}
	
	@GetMapping("/{rating_id}")
	public CreditRating getCreditRating(@PathVariable int rating_id) {
		log.debug("getCreditRatings called with rating_id {}.. ", rating_id);
		return ratingService.findById(rating_id);
		
	}
	
	@GetMapping("/product/{ticker}/rating")
    public CreditRating getCreditRatingForProduct(@PathVariable String ticker) {
        Product product = prodService.findProductByTicker(ticker);
        return ratingService.getCreditRatingForProduct(product);
    }
	
	@PostMapping("/product/{product_id}/agency/{agency_id}")
	public CreditRating saveCreditRating(@Valid @RequestBody CreditRating rating, @PathVariable int product_id, @PathVariable int agency_id) {
		return ratingService.saveRating(rating, product_id, agency_id);
	}
	
	
	@PutMapping("/product/{product_id}/agency/{agency_id}")
	public CreditRating updateCreditRating(@Valid @RequestBody CreditRating rating, @PathVariable int product_id, @PathVariable int agency_id) {
		return ratingService.saveRating(rating, product_id, agency_id);
	}
	
	
	@DeleteMapping("/{rating_id}")
	public void deleteCreditRating(@PathVariable int rating_id) {
		log.debug("deleteCreditRating called with rating_id {}.. ", rating_id);
		
		ratingService.deleteById(rating_id);
		
	}
	
	@DeleteMapping("")
	public void deleteAllRatings() {
		log.debug("deleteAllRatings called.. ");
		ratingService.deleteAllRatings();
		
	}

}
