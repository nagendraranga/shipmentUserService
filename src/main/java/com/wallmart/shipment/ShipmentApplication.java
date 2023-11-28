package com.wallmart.shipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.wallmart.dao.ProductRepository;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "com.wallmart.dao")
@ComponentScan(basePackages = "com.wallmart.*")
public class ShipmentApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShipmentApplication.class, args);
	}

}
