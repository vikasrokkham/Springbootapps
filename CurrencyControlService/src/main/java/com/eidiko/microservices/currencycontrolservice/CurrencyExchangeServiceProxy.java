package com.eidiko.microservices.currencycontrolservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "forex-service",url = "localhost:9090")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable(name = "from") String from, @PathVariable(name = "to")String to); 
}
