package com.wallmart.utilities;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

@Component
public class OrderNumberGenerator {
    private static final int MAX_ORDER_NUMBER = 999;
    private static Random random = new Random();

    public static String generateOrderNumber() {
        String prefix = "ORD";
        int randomDigits = random.nextInt(MAX_ORDER_NUMBER) + 1; // Add 1 to avoid generating 000
        String orderNumber = String.format("%s%03d", prefix, randomDigits);
        return orderNumber;
    }
}