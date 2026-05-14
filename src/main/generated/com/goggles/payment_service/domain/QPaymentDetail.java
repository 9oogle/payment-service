package com.goggles.payment_service.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import javax.annotation.processing.Generated;

/** QPaymentDetail is a Querydsl query type for PaymentDetail */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPaymentDetail extends BeanPath<PaymentDetail> {

  private static final long serialVersionUID = 1571727816L;

  public static final QPaymentDetail paymentDetail = new QPaymentDetail("paymentDetail");

  public final EnumPath<PaymentMethod> method = createEnum("method", PaymentMethod.class);

  public final DateTimePath<java.time.LocalDateTime> paidAt =
      createDateTime("paidAt", java.time.LocalDateTime.class);

  public final StringPath paymentKey = createString("paymentKey");

  public QPaymentDetail(String variable) {
    super(PaymentDetail.class, forVariable(variable));
  }

  public QPaymentDetail(Path<? extends PaymentDetail> path) {
    super(path.getType(), path.getMetadata());
  }

  public QPaymentDetail(PathMetadata metadata) {
    super(PaymentDetail.class, metadata);
  }
}
