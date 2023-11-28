package com.wallmart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentRequest {
    private int pid;
    private int distance;
    private int zipcode;

    // getters and setters
}