package com.goggles.payment_service.domain.event;

import lombok.Getter;
import java.util.UUID;

@Getter
public class PaymentCanceledEvent extends DomainEvent {

    private final UUID orderId;

    public PaymentCanceledEvent(String aggregateId, String correlationId,
                                UUID orderId) {
        super("PAYMENT_CANCELED", aggregateId, correlationId);
        this.orderId = orderId;
    }
}
