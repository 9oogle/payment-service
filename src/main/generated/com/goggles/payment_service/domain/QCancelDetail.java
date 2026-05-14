package com.goggles.payment_service.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCancelDetail is a Querydsl query type for CancelDetail
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QCancelDetail extends BeanPath<CancelDetail> {

    private static final long serialVersionUID = 665952634L;

    public static final QCancelDetail cancelDetail = new QCancelDetail("cancelDetail");

    public final DateTimePath<java.time.LocalDateTime> canceledAt = createDateTime("canceledAt", java.time.LocalDateTime.class);

    public final StringPath reason = createString("reason");

    public QCancelDetail(String variable) {
        super(CancelDetail.class, forVariable(variable));
    }

    public QCancelDetail(Path<? extends CancelDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCancelDetail(PathMetadata metadata) {
        super(CancelDetail.class, metadata);
    }

}

