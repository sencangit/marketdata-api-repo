package com.finance.marketdata.restservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.marketdata.restservices.models.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Integer> {

}
