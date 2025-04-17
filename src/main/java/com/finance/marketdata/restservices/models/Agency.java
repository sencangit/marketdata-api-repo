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
@Table(name = "rating_agencies", schema = "market_data")
public class Agency {
	
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	@JsonProperty("agency_id")
    private Integer agency_id;
    
	@JsonProperty("agency_name")
    private String agency_name;
    
	@JsonProperty("create_dt")
    @Column(name = "create_dt", updatable = false, insertable = false)
    private LocalDate create_dt;

}
