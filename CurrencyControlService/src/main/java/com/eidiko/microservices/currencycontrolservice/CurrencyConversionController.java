package com.eidiko.microservices.currencycontrolservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CurrencyConversionController {
	private static String URL = "http://localhost:9090/currency-exchange/from/{from}/to/{to}";
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable(name = "from") String from, @PathVariable(name = "to")String to,@PathVariable(name = "quantity") BigDecimal quantity){
		HashMap<String, String> uriParams = new HashMap<String, String>();
		
		uriParams.put("from",from);
		uriParams.put("to",to);
		
		
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(URL, CurrencyConversionBean.class, uriParams	);
		CurrencyConversionBean responseBody = responseEntity.getBody();
		return new CurrencyConversionBean(responseBody.getId(),from,to,responseBody.getConversionMultiple(),quantity,quantity.multiply(responseBody.getConversionMultiple()),responseBody.getPort());
	}
}
