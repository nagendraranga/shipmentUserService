package com.wallmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.dto.ShipmentRequest;
import com.wallmart.dto.ShipmentResponse;
import com.wallmart.service.ShipmentService;


@RestController
public class ShipmentController {

 @Autowired
 private ShipmentService shipmentService;

 @PostMapping("/calculateShipment")
 public ShipmentResponse calculateShipmentCharges(@RequestBody ShipmentRequest request) {
     return shipmentService.calculateShipmentCharges(request);
 }
}

