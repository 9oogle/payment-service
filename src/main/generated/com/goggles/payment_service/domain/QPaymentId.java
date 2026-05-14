package com.goggles.payment_service.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentId is a Querydsl query type for PaymentId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPaymentId extends BeanPath<PaymentId> {

    private static final long serialVersionUID = -113380846L;

    public static final QPaymentId paymentId = new QPaymentId("paymentId");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public QPaymentId(String variable) {
        super(PaymentId.class, forVariable(variable));
    }

    public QPaymentId(Path<? extends PaymentId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentId(PathMetadata metadata) {
        super(PaymentId.class, metadata);
    }

}

