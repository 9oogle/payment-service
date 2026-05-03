package com.goggles.payment_service.infrastructure.kafka;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEventDto {

  private UUID orderID;
  private UUID userId;
  private Long amount;
  private String paymentMethod;
}
