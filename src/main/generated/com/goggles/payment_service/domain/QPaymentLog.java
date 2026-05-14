package com.goggles.payment_service.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPaymentLog is a Querydsl query type for PaymentLog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentLog extends EntityPathBase<PaymentLog> {

    private static final long serialVersionUID = 780164397L;

    public static final QPaymentLog paymentLog = new QPaymentLog("paymentLog");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final EnumPath<PaymentStatus> fromStatus = createEnum("fromStatus", PaymentStatus.class);

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath log = createString("log");

    public final EnumPath<PaymentStatus> toStatus = createEnum("toStatus", PaymentStatus.class);

    public QPaymentLog(String variable) {
        super(PaymentLog.class, forVariable(variable));
    }

    public QPaymentLog(Path<? extends PaymentLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentLog(PathMetadata metadata) {
        super(PaymentLog.class, metadata);
    }

}

