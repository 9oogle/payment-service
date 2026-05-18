package com.goggles.payment_service.application.dto;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentServiceDto {

  @Builder
  public record Create(
      UUID orderId,
      String productName,
      long orderPrice,
      UUID customerId,
      String customerName,
      String customerEmail) {}
}
