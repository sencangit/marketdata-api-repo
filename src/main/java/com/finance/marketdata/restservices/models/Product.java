package com.finance.marketdata.restservices.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "market_products")
public class Product {

	
	@Id
	@GeneratedValue /* (strategy = GenerationType.AUTO) */
	@JsonProperty("product_id")
	@Min(1)
	@Max(5000)
	private Integer productId;
	
	
	@JsonProperty("ticker_name")
	@NotBlank(message = "Ticker Name is mandatory")
	@Size(
	        min = 2, max = 8,
	        message = "Ticker Name should have a length between 2 and 8 characters")
	private String tickerName;
	
	
	@JsonProperty("price_date")
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate priceDate;
	
	@JsonProperty("price")	
	private BigDecimal price;



}
