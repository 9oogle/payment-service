package com.goggles.payment_service.presentation.dto;

import com.goggles.payment_service.domain.Payment;
import com.goggles.payment_service.domain.PaymentMethod;
import com.goggles.payment_service.domain.PaymentStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class PaymentResponse {

    private final UUID id;
    private final UUID orderID;
    private final Long amount;
    private final PaymentStatus status;
    private final PaymentMethod method;
    private final String transactionId;
    private final String failReason;
    private final LocalDateTime paidAt;

    private PaymentResponse(Payment payment) {
        this.id = payment.getId();
        this.orderID = payment.getOrderId();
        this.amount = payment.getAmount().getAmount();
        this.status = payment.getStatus();
        this.method = payment.getMethod();
        this.transactionId = payment.getTransactionId();
        this.failReason = payment.getFailReason();
        this.paidAt = payment.getPaidAt();
    }

    public static PaymentResponse from(Payment payment) {
        return new PaymentResponse(payment);
    }
}
