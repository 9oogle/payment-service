package com.goggles.payment_service.infrastructure.persistence;

import com.goggles.payment_service.domain.Payment;
import com.goggles.payment_service.domain.QPayment;
import com.goggles.payment_service.domain.query.PaymentQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentQueryRepositoryImpl implements PaymentQueryRepository {

  private final JPAQueryFactory queryFactory;

  @Override
  public Optional<Payment> findByOrderId(UUID orderId) {

    QPayment payment = QPayment.payment;

    return Optional.ofNullable(
        queryFactory.selectFrom(payment).where(payment.orderDetail.orderId.eq(orderId)).fetchOne());
  }
}
