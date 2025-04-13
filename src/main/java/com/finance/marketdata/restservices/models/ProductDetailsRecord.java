package com.finance.marketdata.restservices.models;

public record ProductDetailsRecord(
		
		String realtime_start,
		
		String realtime_end,
		
		String observation_start,
		
		String observation_end,
		
		String units,
		
		int output_type,
		
		String file_type,
		
		String order_by,
		
		String sort_order,
		
		int count,
		
		int offset,
		
		int limit,
		
		ObservationRecord [] observations

	) {}
