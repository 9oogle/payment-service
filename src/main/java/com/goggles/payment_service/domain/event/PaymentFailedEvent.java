package com.goggles.payment_service.domain.event;

import java.util.UUID;
import lombok.Getter;

@Getter
public class PaymentFailedEvent extends DomainEvent {

  private final UUID orderId;
  private final String failReason;

  public PaymentFailedEvent(
      String aggregateId, String correlationId, UUID orderId, String failReason) {
    super("PAYMENT_FAILED", aggregateId, correlationId);
    this.orderId = orderId;
    this.failReason = failReason;
  }
}
