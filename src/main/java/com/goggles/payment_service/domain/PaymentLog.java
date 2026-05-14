package com.goggles.payment_service.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@ToString
@Table(name = "p_payment_log")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class PaymentLog {

  @Id
  @Column(length = 45)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(length = 30, nullable = false)
  @Enumerated(EnumType.STRING)
  private PaymentStatus fromStatus;

  @Column(length = 30, nullable = false)
  @Enumerated(EnumType.STRING)
  private PaymentStatus toStatus;

  @Lob private String log;

  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime createdAt;

  protected PaymentLog(PaymentStatus fromStatus, PaymentStatus toStatus, String log) {
    this.fromStatus = fromStatus;
    this.toStatus = toStatus;
    this.log = log;
  }
}
