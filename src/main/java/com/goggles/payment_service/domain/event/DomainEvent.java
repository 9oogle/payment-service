package com.goggles.payment_service.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;

@Getter
public abstract class DomainEvent {

  private final String eventId;
  private final LocalDateTime occurredAt;
  private final String eventType;
  private final String aggregateId;
  private final String correlationId;

  protected DomainEvent(String eventType, String aggregateId, String correlationId) {
    this.eventId = UUID.randomUUID().toString();
    this.occurredAt = LocalDateTime.now();
    this.eventType = eventType;
    this.aggregateId = aggregateId;
    this.correlationId = correlationId;
  }
}
