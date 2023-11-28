package com.wallmart.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Embeddable;



import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;


@Getter
@Setter
@Document(collection = "products")
	public class Product {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private ObjectId id;
	    private int productId;
	    private String title;
	    private int minQuantity;
	    private String gender;
	    private String iconUrl;
	    private String shortDescription;
	    private String longDescription;
	    private String productName;
	    private String productCategory;
	    private String inventoryStatus;
	    private int availableQuantity;
	    private String purchasable;
	
	    @ElementCollection
	    private List<String> searchTags;
	
	    private String model;
	    private String brand;
	    private String specification;
	    private int warrantyDuration;
	
	    @ElementCollection
	    private List<String> imageUrls;
	
	    private int orderLimit;
	    private int returnDates;
	    private double length;
	    private double width;
	    private double height;
	    private double weight;
	
	    @ElementCollection
	    @CollectionTable(name = "product_comments")
	    private List<Comment> comments;
	
	    private boolean isEligibleForPromotion;
	    private double discount;
	    private String isHazardous;
	    private String isReturnable;
	    
	    @Getter
	    @Setter
	    @Embeddable
	    public static class Comment {
	        private String userId;
	        private String comment;
	        private int rate;

	    }

	}

