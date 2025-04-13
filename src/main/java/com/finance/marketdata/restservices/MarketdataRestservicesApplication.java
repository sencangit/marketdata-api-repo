package com.finance.marketdata.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MarketdataRestservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketdataRestservicesApplication.class, args);
	}

}
