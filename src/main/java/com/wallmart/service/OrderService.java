package com.wallmart.service;

public interface OrderService {
    void processOrder(Long itemId, String customerAddress, String customerMobile, String customerEmail);
}
