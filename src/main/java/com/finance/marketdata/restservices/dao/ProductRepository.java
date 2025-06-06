package com.finance.marketdata.restservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.marketdata.restservices.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findBytickerName(String ticker_name);
}
