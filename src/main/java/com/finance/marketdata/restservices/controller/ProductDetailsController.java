package com.finance.marketdata.restservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.finance.marketdata.restservices.models.ProductDetailsRecord;
import com.finance.marketdata.restservices.service.ProductDetailsDaoService;

@RestController
@RequestMapping("/v1/productDetails")
public class ProductDetailsController {

	private Logger logger = LoggerFactory.getLogger(ProductDetailsController.class);

	@Autowired
	private ProductDetailsDaoService productDetailsService;

	@GetMapping("/series/{series_id}/lastPrice")
	public ProductDetailsRecord getProductSeriesLastPrice(@PathVariable("series_id") String series_id)
			throws JsonMappingException, JsonProcessingException {
		
		logger.debug("getProductSeriesLastPrice called with series_id..{} ", series_id);

		return productDetailsService.retrieveLatestPrice(series_id);

	}

	
	  @GetMapping("/series/{series_id}/history") 
	  public ProductDetailsRecord getProductSeriesHistory(@PathVariable("series_id") String series_id) {
	  
		  logger.debug("getProductSeriesHistory called with series_id..{} ", series_id);
		  
		  return productDetailsService.retrieveOneMonthHistory(series_id);
	  }
	 

}
