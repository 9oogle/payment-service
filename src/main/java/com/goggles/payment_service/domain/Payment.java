package com.goggles.payment_service.domain;

import com.goggles.common.domain.BaseAudit;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "p_payment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "order_id", nullable = false)
    private UUID orderId;

    @Embedded
    private Money amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private PaymentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "method", nullable = false, length = 20)
    private PaymentMethod method;

    @Column(name = "transaction_id", length = 100)
    private String transactionId;

    @Column(name = "fail_reason", length = 255)
    private String failReason;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    // 생성
    public static Payment create(UUID orderId, Long amount) {
        Payment payment = new Payment();
        payment.orderId = orderId;
        payment.amount = Money.of(amount);
        payment.status = PaymentStatus.READY;
        payment.method = PaymentMethod.TOSS;
        return payment;
    }

    // READY -> SUCCESS
    public void success(String transactionId) {
        if (this.status != PaymentStatus.READY) {
            throw new IllegalStateException("READY 상태에서만 SUCESS로 전이 가능합니다.");
        }
        this.status = PaymentStatus.SUCCESS;
        this.transactionId = transactionId;
        this.paidAt = LocalDateTime.now();
    }

    // READY -> FAIL
    public void fail(String transactionId, String failReason) {
        if (this.status != PaymentStatus.READY) {
            throw new IllegalStateException("READY 상태에서만 FAIL로 전이 가능합니다.");
        }
        this.status = PaymentStatus.FAIL;
        this.transactionId = transactionId;
        this.failReason = failReason;
    }

    // SUCCESS -> CANCEL
    public void cancel() {
        if(this.status != PaymentStatus.SUCCESS) {
            throw new IllegalStateException("SUCCESS 상태에서만 CANCEL로 전이 가능합니다.");
        }
        this.status = PaymentStatus.CANCEL;
    }
}
