package com.goggles.payment_service.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCompletedEvent extends DomainEvent {

  private UUID orderId;
  private Long amount;
  private LocalDateTime paidAt;

  public PaymentCompletedEvent(
      String aggregateId, String correlationId, UUID orderId, Long amount, LocalDateTime paidAt) {
    super("PAYMENT_COMPLETED", aggregateId, correlationId);
    this.orderId = orderId;
    this.amount = amount;
    this.paidAt = paidAt;
  }
}
