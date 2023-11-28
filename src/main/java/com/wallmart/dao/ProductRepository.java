package com.wallmart.dao;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.wallmart.entities.Product;
import org.bson.types.ObjectId;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
	Product findByProductId(long productId);
   
}
