package com.finance.marketdata.restservices.models;

import java.time.LocalDateTime;

public record ErrorDetailsRecord(
		
		LocalDateTime timestamp,
		String message,
		String details
		) {

}
