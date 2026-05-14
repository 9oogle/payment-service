package com.goggles.payment_service.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import javax.annotation.processing.Generated;

/** QOrderDetail is a Querydsl query type for OrderDetail */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QOrderDetail extends BeanPath<OrderDetail> {

  private static final long serialVersionUID = 1143253328L;

  public static final QOrderDetail orderDetail = new QOrderDetail("orderDetail");

  public final StringPath customerEmail = createString("customerEmail");

  public final ComparablePath<java.util.UUID> customerId =
      createComparable("customerId", java.util.UUID.class);

  public final StringPath customerName = createString("customerName");

  public final ComparablePath<java.util.UUID> orderId =
      createComparable("orderId", java.util.UUID.class);

  public final NumberPath<Long> orderPrice = createNumber("orderPrice", Long.class);

  public final StringPath productName = createString("productName");

  public QOrderDetail(String variable) {
    super(OrderDetail.class, forVariable(variable));
  }

  public QOrderDetail(Path<? extends OrderDetail> path) {
    super(path.getType(), path.getMetadata());
  }

  public QOrderDetail(PathMetadata metadata) {
    super(OrderDetail.class, metadata);
  }
}
