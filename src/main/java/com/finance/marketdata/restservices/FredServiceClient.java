package com.finance.marketdata.restservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finance.marketdata.restservices.models.ProductDetailsRecord;

@FeignClient(value = "fredservice", url = "https://api.stlouisfed.org/fred/series")
public interface FredServiceClient {
	
	  @RequestMapping(method = RequestMethod.GET, value = "/observations", produces = "application/json")
	  public ProductDetailsRecord getStockDetails (@RequestParam("series_id") String series_id,
			  	@RequestParam("api_key") String api_key,
			  	@RequestParam("observation_start") String observation_start,
			  	@RequestParam("observation_end") String observation_end,
			  	@RequestParam("file_type") String file_type);
}