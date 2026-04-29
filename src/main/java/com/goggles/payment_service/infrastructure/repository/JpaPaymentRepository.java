package com.goggles.payment_service.infrastructure.repository;

import com.goggles.payment_service.domain.Payment;
import com.goggles.payment_service.domain.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaPaymentRepository extends JpaRepository<Payment, UUID> {
    Optional<Payment> findByOrderId(UUID orderID);

    boolean existsByOrderIdAndStatus(UUID orderId, PaymentStatus status);
}
