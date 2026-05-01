package com.goggles.payment_service.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCanceledEvent extends DomainEvent {

  private UUID orderId;

  public PaymentCanceledEvent(String aggregateId, String correlationId, UUID orderId) {
    super("PAYMENT_CANCELED", aggregateId, correlationId);
    this.orderId = orderId;
  }
}
