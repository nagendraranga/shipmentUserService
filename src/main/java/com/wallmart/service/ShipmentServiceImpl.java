package com.wallmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wallmart.dao.ProductRepository;
import com.wallmart.dao.RuleRepository;
import com.wallmart.dto.ShipmentDetails;
import com.wallmart.dto.ShipmentOption;
import com.wallmart.dto.ShipmentRequest;
import com.wallmart.dto.ShipmentResponse;
import com.wallmart.entities.Product;
import com.wallmart.entities.Rule;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ShipmentResponse calculateShipmentCharges(ShipmentRequest request) {
        ShipmentResponse response = new ShipmentResponse();
        response.setPid(request.getPid());

        // Find the rule based on distance and weight
        Rule rule = findRule(request.getDistance(), getProductWeight(request.getPid()));

        // Calculate charges
        if (rule != null) {
            response.setShipment(calculateShipmentOptions(rule));
        }

        return response;
    }

    private Rule findRule(int distance, int weight) {
        // Adjust this logic based on rounding off
        // For simplicity, we assume that there is an exact match for distance and weight

        return ruleRepository.findByDistanceAndWeight(distance, weight);
    }

    private ShipmentDetails calculateShipmentOptions(Rule rule) {
        ShipmentDetails shipmentDetails = new ShipmentDetails();
        
        shipmentDetails.setSamedayDelivery(createShipmentOption(rule.getSameDay() + rule.getShipCharges()));
        shipmentDetails.setExpressDelivery(createShipmentOption(rule.getExpress() + rule.getShipCharges()));
        shipmentDetails.setStandardDelivery(createShipmentOption(rule.getShipCharges()));

        return shipmentDetails;
    }

    private ShipmentOption createShipmentOption(double extraCharges) {
        ShipmentOption shipmentOption = new ShipmentOption();
        shipmentOption.setEligible(true); // Adjust eligibility logic based on your requirements
        shipmentOption.setPrice(extraCharges);

        return shipmentOption;
    }

    private int getProductWeight(int productId) {
        // Logic to get the weight from the product table based on the productId
        // Adjust this logic based on your specific requirements

        Product product = productRepository.findByProductId(productId);
        return (product != null) ? (int) product.getWeight() : 0;
    }

}

