package com.goggles.payment_service.domain.event;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class PaymentFailedEvent extends DomainEvent {

    private final UUID orderId;
    private final String failReason;

    public PaymentFailedEvent(String aggregateId, String correlationId,
                              UUID orderId, String failReason) {
        super("PAYMENT_FAILED", aggregateId, correlationId);
            this.orderId = orderId;
            this.failReason = failReason;
    }
}
