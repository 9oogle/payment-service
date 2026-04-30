package com.goggles.payment_service.domain.event;

import java.util.UUID;
import lombok.Getter;

@Getter
public class PaymentCancelRequestedEvent extends DomainEvent {

  private final UUID orderId;
  private final String transactionId;

  public PaymentCancelRequestedEvent(
      String aggregateID, String correlationID, UUID orderId, String transactionId) {
    super("PAYMENT_CANCEL_REQUESTED", aggregateID, correlationID);
    this.orderId = orderId;
    this.transactionId = transactionId;
  }
}
