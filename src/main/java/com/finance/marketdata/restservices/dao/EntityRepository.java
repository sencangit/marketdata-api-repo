package com.finance.marketdata.restservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.marketdata.restservices.models.EntityDetails;

@Repository
public interface EntityRepository extends JpaRepository<EntityDetails, Integer> {

}
