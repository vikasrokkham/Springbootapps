/**
 * 
 */
package com.eidiko.microservices.forexservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.microservices.forexservice.entity.ExchangeValue;

/**
 * @author Administrator
 *
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);
	
}
