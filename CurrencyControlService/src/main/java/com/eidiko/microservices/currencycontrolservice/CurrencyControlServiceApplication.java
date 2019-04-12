package com.eidiko.microservices.currencycontrolservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.eidiko.microservices.currencycontrolservice")
public class CurrencyControlServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyControlServiceApplication.class, args);
	}

}
