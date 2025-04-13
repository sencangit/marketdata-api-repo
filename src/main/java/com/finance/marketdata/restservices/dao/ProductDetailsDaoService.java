package com.finance.marketdata.restservices.dao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.marketdata.restservices.FredServiceClient;
import com.finance.marketdata.restservices.models.ProductDetailsRecord;

@Service
public class ProductDetailsDaoService {

	@Autowired
	private FredServiceClient fredServiceClient;

	public ProductDetailsRecord retrieveLatestPrice(String series_id) {
		LocalDate todaysDate = LocalDate.now();
		//System.out.println("todaysDate" + todaysDate);

		String observation_start = todaysDate.toString();
		String observation_end = observation_start;

		String file_type = "json";

		return fredServiceClient.getStockDetails(series_id, "cf760769bce09f77de6b5c9122b9e084", observation_start,
				observation_end, file_type);

	}

	public ProductDetailsRecord retrieveOneMonthHistory(String series_id) {
		
		LocalDate todaysDate = LocalDate.now();
		//System.out.println("todaysDate" + todaysDate);

		String observation_start = todaysDate.minusMonths(1).toString();
		String observation_end = todaysDate.toString();
		
		String file_type = "json";
		
		return fredServiceClient.getStockDetails(series_id, "cf760769bce09f77de6b5c9122b9e084", observation_start,
				observation_end, file_type);
		
	}

}