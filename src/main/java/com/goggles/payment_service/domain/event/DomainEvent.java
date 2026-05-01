package com.goggles.payment_service.domain.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class DomainEvent {

  private String eventId;
  private LocalDateTime occurredAt;
  private String eventType;
  private String aggregateId;
  private String correlationId;

  protected DomainEvent(String eventType, String aggregateId, String correlationId) {
    this.eventId = UUID.randomUUID().toString();
    this.occurredAt = LocalDateTime.now();
    this.eventType = eventType;
    this.aggregateId = aggregateId;
    this.correlationId = correlationId;
  }
}
