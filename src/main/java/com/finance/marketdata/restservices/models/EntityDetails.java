package com.finance.marketdata.restservices.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "entity_details", schema = "market_data")
public class EntityDetails {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@JsonProperty("entity_id")
    private Integer entity_id;
    
	@JsonProperty("entity_name")
    private String entity_name;
    
	@JsonProperty("country")
    private String country;
    
	@JsonProperty("create_dt")
    @Column(name = "create_dt", updatable = false, insertable = false)
    private LocalDate create_dt;
}
