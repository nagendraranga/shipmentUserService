package com.wallmart.service;

import com.wallmart.dto.ShipmentRequest;
import com.wallmart.dto.ShipmentResponse;

public interface ShipmentService {
    ShipmentResponse calculateShipmentCharges(ShipmentRequest request);
}
