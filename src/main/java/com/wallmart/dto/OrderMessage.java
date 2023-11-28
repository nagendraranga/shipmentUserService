package com.wallmart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderMessage {
    private Long orderId;
    private String orderNumber;
    private String customerAddress;

}
