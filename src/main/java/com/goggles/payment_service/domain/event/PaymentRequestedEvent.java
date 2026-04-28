package com.goggles.payment_service.domain.event;

import lombok.Getter;

import java.util.UUID;

@Getter
public class PaymentRequestedEvent extends DomainEvent {

    private final UUID orderId;
    private final Long amount;

    public PaymentRequestedEvent(String aggregateId, String correlationId,
                                 UUID orderId, Long amount) {
        super("PAYMENT_REQUESTED", aggregateId, correlationId);
        this.orderId = orderId;
        this.amount = amount;
    }
}
