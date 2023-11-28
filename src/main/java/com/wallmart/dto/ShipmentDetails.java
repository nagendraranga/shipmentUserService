package com.wallmart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentDetails {
    private ShipmentOption samedayDelivery;
    private ShipmentOption expressDelivery;
    private ShipmentOption standardDelivery;

}
