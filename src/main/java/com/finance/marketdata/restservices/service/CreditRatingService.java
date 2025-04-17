package com.finance.marketdata.restservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.marketdata.restservices.dao.AgencyRepository;
import com.finance.marketdata.restservices.dao.ProductRepository;
import com.finance.marketdata.restservices.dao.RatingRepository;
import com.finance.marketdata.restservices.exception.ProductNotFoundException;
import com.finance.marketdata.restservices.models.Agency;
import com.finance.marketdata.restservices.models.CreditRating;
import com.finance.marketdata.restservices.models.Product;

@Service
public class CreditRatingService {
	
	@Autowired
	private RatingRepository ratingRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private AgencyRepository agencyRepo;
	
	public CreditRating findById(int rating_id) {

		CreditRating ratingObj = ratingRepo.findById(rating_id)
				.orElseThrow(() -> new ProductNotFoundException("rating_id: " + rating_id + "--> not found."));
		
		return ratingObj;
	}

	public CreditRating saveRating(CreditRating rating, int product_id, int agency_id) {
		
		 Product prodObj = productRepo.findById(product_id)
	                .orElseThrow(() -> new ProductNotFoundException("Product id: " + product_id + "--> not found"));
		 
		 
		 Agency agencyObj = agencyRepo.findById(agency_id)
	                .orElseThrow(() -> new ProductNotFoundException("Agency id: " + agency_id + "--> not found"));
		 
		 rating.setProduct(prodObj);
		 rating.setAgency(agencyObj);
		 
		return ratingRepo.save(rating);
	}

	public List<CreditRating> findAllRatings() {
		return ratingRepo.findAll();
	}

	public void deleteById(int rating_id) {
		ratingRepo.findById(rating_id)
				.orElseThrow(() -> new ProductNotFoundException("rating_id: " + rating_id + "--> not found."));
		
		ratingRepo.deleteById(rating_id);
	}

	public void deleteAllRatings() {
		ratingRepo.deleteAll();
	}

	public CreditRating getCreditRatingForProduct(Product product) {
		return ratingRepo.findByProduct(product).stream().findFirst().orElse(null);
	}
}
