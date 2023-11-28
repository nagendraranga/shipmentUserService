package com.wallmart.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private ObjectId id;
		private Long itemId;
	    private String customerAddress;
	    private String customerMobile;
	    private String customerEmail;
}
