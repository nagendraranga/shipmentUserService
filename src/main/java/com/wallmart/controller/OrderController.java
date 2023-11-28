package com.wallmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wallmart.dto.OrderRequestDto;
import com.wallmart.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody OrderRequestDto orderRequestDto) {
        orderService.processOrder(
            orderRequestDto.getItemId(),
            orderRequestDto.getCustomerAddress(),
            orderRequestDto.getCustomerMobile(),
            orderRequestDto.getCustomerEmail()
        );
    }
}

