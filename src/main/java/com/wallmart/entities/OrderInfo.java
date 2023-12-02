package com.wallmart.entities;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "OrderInfo")
public class OrderInfo {

   @Id
   private Integer orderId;
   private Integer cartId;
   private Integer userId;
   private String dateOfOrder;
   private BigDecimal amount;
   private String modeOfPayment;
   private String paymentStatus;
   private String dateOfDelivery;
   private String statusOfOrder;
   
}
