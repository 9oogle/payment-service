package com.goggles.payment_service.infrastructure.toss;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TossPaymentClient {

    private final TossPaymentProperties properties;
    private final RestTemplate restTemplate;

    // 결제 승인
    public Map<String, Object> confirm(String paymentKey, String orderId, Long amount) {
        HttpHeaders headers = createHeaders();
        Map<String, Object> body = Map.of(
                "paymentKey", paymentKey,
                "orderId", orderId,
                "amount", amount
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                properties.getBaseUrl() + "/confirm",
                HttpMethod.POST,
                request,
                Map.class
        );

        return response.getBody();
    }

    // 결제 취소
    public Map<String, Object> cancel(String transactionId, String cancelReason) {
        HttpHeaders headers = createHeaders();
        Map<String, Object> body = Map.of("canselReason", cancelReason);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                properties.getBaseUrl() + "/" + transactionId + "/cancel",
                HttpMethod.POST,
                request,
                Map.class
        );

        return response.getBody();
    }

    private HttpHeaders createHeaders() {
        String encoded = Base64.getEncoder()
                .encodeToString((properties.getSecretKey() + ":").getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Basic" + encoded);
        return headers;
    }
}
