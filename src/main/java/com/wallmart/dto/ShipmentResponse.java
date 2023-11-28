package com.wallmart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentResponse {
    private int pid;
    private ShipmentDetails shipment;

}