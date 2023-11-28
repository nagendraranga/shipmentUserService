package com.wallmart.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.wallmart.entities.Orders;
import com.wallmart.entities.Product;

public interface OrderRepository extends MongoRepository<Orders, ObjectId> {
	Orders findByOrderNumber(String orderNumber);
}

