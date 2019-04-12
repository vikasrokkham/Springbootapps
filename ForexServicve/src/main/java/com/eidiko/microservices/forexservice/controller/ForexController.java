package com.eidiko.microservices.forexservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.microservices.forexservice.entity.ExchangeValue;
import com.eidiko.microservices.forexservice.service.ExchangeValueRepository;

@RestController
public class ForexController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repoExchangeValueRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable(name = "from") String from,@PathVariable(name = "to") String to){
		ExchangeValue excVal = repoExchangeValueRepository.findByFromAndTo(from, to);
		
		excVal.setPort(Integer.valueOf(environment.getProperty("server.port")));
		System.out.println("Exchange Value "+excVal.toString());
		return excVal;
	}

}
