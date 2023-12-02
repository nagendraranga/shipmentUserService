package com.wallmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wallmart.dao.OrderInfoRepository;
import com.wallmart.entities.OrderInfo;

@RestController

public class OrderInfoController {

    @Autowired
    OrderInfoRepository orderInfoRepository;

    @PostMapping("/updateOrder")
    public OrderInfo calculateShipmentCharges(@RequestBody OrderInfo orderInfo) {
        return orderInfoRepository.save(orderInfo);
    }
}
