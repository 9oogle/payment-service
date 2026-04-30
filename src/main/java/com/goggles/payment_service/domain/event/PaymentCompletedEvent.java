package com.goggles.payment_service.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

@Getter
public class PaymentCompletedEvent extends DomainEvent {

  private final UUID orderId;
  private final Long amount;
  private final LocalDateTime paidAt;

  public PaymentCompletedEvent(
      String aggregateId, String correlationId, UUID orderId, Long amount, LocalDateTime paidAt) {
    super("PAYMENT_COMPLETED", aggregateId, correlationId);
    this.orderId = orderId;
    this.amount = amount;
    this.paidAt = paidAt;
  }
}
