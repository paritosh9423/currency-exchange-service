package com.paritosh.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.paritosh.microservices.currencyexchangeservice.bean.ExchangeValue;

@RestController
public class CurrencyExchangeController {
	@Autowired
	Environment env;

	@GetMapping("currency-exchange/{from}/to/{to}")
	public ExchangeValue retrieveExchangeCalue(@PathVariable String from , @PathVariable String to) {
		ExchangeValue 	ev = new ExchangeValue(1000L, from, to, new BigDecimal("75"));
		ev.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return ev;
	}
	
}
