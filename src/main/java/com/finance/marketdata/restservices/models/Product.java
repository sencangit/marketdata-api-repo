package com.finance.marketdata.restservices.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "market_products", schema = "market_data")
public class Product {
	
	@Id
	@GeneratedValue  (strategy = GenerationType.IDENTITY)
	@Min(1)
	@Max(5000)
	@JsonProperty("product_id")
	private Integer product_id;

	@NotBlank(message = "Ticker Name is mandatory")
	@Size(
	        min = 2, max = 10,
	        message = "Ticker Name should have a length between 2 and 10 characters")
	@JsonProperty("ticker_name")
	@Column(name = "ticker_name")
	private String tickerName;


	public String getTickerName() {
		return tickerName;
	}


	public void setTickerName(String tickerName) {
		this.tickerName = tickerName;
	}


	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate price_date;
	
	@JsonProperty("price")
	private BigDecimal price;
	
	@Column(name = "create_dt", updatable = false, insertable = false)
	@JsonProperty("create_dt")
	private LocalDate create_dt;
	
	
	  @ManyToOne	  
	  @JoinColumn(name = "entity_id", referencedColumnName = "entity_id", nullable = false)
	  @JsonProperty("entity")
	  private EntityDetails entity;


	public EntityDetails getEntity() {
		return entity;
	}


	public void setEntity(EntityDetails entity) {
		this.entity = entity;
	}
	
	public Integer getProduct_id() {
		return product_id;
	}


	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	
	/*
	 * public String getTicker_name() { return ticker_name; }
	 * 
	 * 
	 * public void setTicker_name(String ticker_name) { this.ticker_name =
	 * ticker_name; }
	 */


	public LocalDate getPrice_date() {
		return price_date;
	}


	public void setPrice_date(LocalDate price_date) {
		this.price_date = price_date;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	 
}
