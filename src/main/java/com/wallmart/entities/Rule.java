package com.wallmart.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "rules")
public class Rule {
    @Id
    private String id;
    private int rule_id;
    private int distance;
    private int weight;
    private double shipCharges;
    private double sameday;
    private double express;
	public double getSameDay() {
		return sameday;
	}

}
