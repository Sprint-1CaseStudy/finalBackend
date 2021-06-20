package com.example.onlinesportshopee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineSportsShopeeApplication {
	
	static final Logger LOGGER = LoggerFactory.getLogger(OnlineSportsShopeeApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("Online Sports Shopee Application Initiated");
		
		SpringApplication.run(OnlineSportsShopeeApplication.class, args);
	}

}
