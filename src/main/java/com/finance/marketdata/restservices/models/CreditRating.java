package com.finance.marketdata.restservices.models;

import java.time.LocalDate;
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
@Table(name = "credit_ratings", schema = "market_data")
public class CreditRating {
	
	@Id
	@GeneratedValue  (strategy = GenerationType.IDENTITY)
	@Min(1)
	@Max(5000)
	@JsonProperty("rating_id")
	private Integer rating_id;
	 
	 @ManyToOne	  
	  @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
	  @JsonProperty("product")
	  private Product product;
	 
	 @ManyToOne	  
	  @JoinColumn(name = "agency_id", referencedColumnName = "agency_id", nullable = false)
	  @JsonProperty("agency")
	  private Agency agency;


	@NotBlank(message = "Rating is mandatory")
	@Size(
	        min = 1, max = 10,
	        message = "Rating should have a length between 1 and 10 characters")
	@JsonProperty("rating")
	private String rating;


	@NotBlank(message = "Review is mandatory")
	@Size(
	        min = 2, max = 50,
	        message = "Review should have a length between 2 and 50 characters")
	@JsonProperty("review")
	private String review;
	
	@Column(name = "create_dt", updatable = false, insertable = false)
	@JsonProperty("create_dt")
	private LocalDate create_dt;

	public Integer getRating_id() {
		return rating_id;
	}

	public void setRating_id(Integer rating_id) {
		this.rating_id = rating_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public LocalDate getCreate_dt() {
		return create_dt;
	}

	
	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
}
