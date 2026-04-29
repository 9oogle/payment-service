package com.goggles.payment_service.domain.service;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApproveResult {

    private final boolean success;
    private final String paymentId;
    private final String failReason;
    private final LocalDateTime approveAt;
    private final String paymentLog;
}
