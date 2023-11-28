package com.wallmart.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wallmart.entities.Rule;

public interface RuleRepository extends MongoRepository<Rule, String> {

	Rule findByDistanceAndWeight(int distance, int weight);
	
}
