package com.wallmart.service;

import java.util.Optional;
import java.time.LocalDate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wallmart.dao.OrderRepository;
import com.wallmart.dao.ProductRepository;
import com.wallmart.entities.Orders;
import com.wallmart.entities.Product;
import com.wallmart.exceptions.ProductNotFoundException;
import com.wallmart.utilities.EmailService;
import com.wallmart.utilities.OrderNumberGenerator;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductRepository productRepository; 

    @Autowired
    private OrderRepository orderRepository; 
    
    @Autowired
    private OrderNumberGenerator orderGen;
    
    @Autowired
    private EmailService email;

//    @Autowired
//    private KafkaTemplate<String, OrderMessage> kafkaTemplate; 
    @Override
    public void processOrder(Long itemId, String customerAddress, String customerMobile, String customerEmail) {
        // Retrieve the product from the database using itemId
    	Product product = productRepository.findByProductId(itemId);
		if (product == null) {
		    throw new ProductNotFoundException(itemId);
		}
        // Create an order
        Orders order = new Orders();
        order.setProduct(product);
        order.setCustomerAddress(customerAddress);
        order.setCustomerMobile(customerMobile);
        order.setCustomerEmail(customerEmail);

        String orderNumber = orderGen.generateOrderNumber();
        order.setOrderNumber(orderNumber);
        order.setOrderDate(LocalDate.now());
        email.sendOrderDetailsToCustomer(customerEmail, orderNumber, order);

        // Save the order to the database
        orderRepository.save(order);

        // Produce the order message to the Kafka topic for the courier company
        // OrderMessage orderMessage = new OrderMessage(order.getId(), orderNumber, customerAddress);
        // kafkaTemplate.send("order-topic", orderMessage);
    }

    // Implement methods for generating order number and sending email
}
