package com.goggles.payment_service.infrastructure.toss;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

@Slf4j
@Component
@RequiredArgsConstructor
public class TossPaymentClient {

  private final TossApiHelper tossApiHelper;

  // 결제 승인
  public JsonNode confirm(String paymentKey, String orderId, Long amount) {
    RestClient restClient = tossApiHelper.getRestClient();

    log.info("토스 결제 승인 요청 시작, 주문 ID : {}, Payment Key: {}, 결제금액 : {}", orderId, paymentKey, amount);

    try {
      JsonNode result =
          restClient
              .post()
              .uri(uriBuilder -> uriBuilder.path("/confirm").build())
              .body(
                  Map.of(
                      "paymentKey", paymentKey,
                      "orderId", orderId,
                      "amount", amount))
              .header("Idempotency-Key", orderId)
              .retrieve()
              .body(JsonNode.class);

      log.info("토스 결제 승인 성공, 주문 ID: {}, Payment Key: {}", orderId, paymentKey);
      return result;
    } catch (RestClientResponseException e) {
      JsonNode result = e.getResponseBodyAs(JsonNode.class);
      String code =
          result == null || result.get("code") == null ? "UNKNOWN" : result.get("code").asText();
      String message =
          result == null || result.get("message") == null ? "NIKNOWN" : result.get("code").asText();

      log.error(
          "토스 결제 승인 실패, HTTP 상태코드: {}, 주문 ID: {}, 에러코드: {}, 에러메세지: {}",
          e.getStatusCode().value(),
          orderId,
          code,
          message);
      throw new RuntimeException("[%s]%s".formatted(code, message));
    } catch (Exception e) {
      log.error("토스 결제 승인 실패, 주문 ID: {}, 에러메세지: {}", orderId, e.getMessage());
      throw new RuntimeException("[UNKNOWN]" + e.getMessage());
    }
  }

  // 결제 취소
  public JsonNode cancel(String paymentKey, String cancelReason, String idempotencyKey) {
    RestClient restClient = tossApiHelper.getRestClient();

    log.info("톳 결제 취소 요청 시작, Payment Key: {}", paymentKey);

    try {
      JsonNode result =
          restClient
              .post()
              .uri(uriBuilder -> uriBuilder.path("/{paymentKey}/cancel").build(paymentKey))
              .header("Idempotency-Key", idempotencyKey)
              .body(Map.of("cancelReason", cancelReason))
              .retrieve()
              .body(JsonNode.class);

      log.info("토스 결제 취소 성공, Payment KEy: {}", paymentKey);
      return result;
    } catch (RestClientResponseException e) {
      JsonNode result = e.getResponseBodyAs(JsonNode.class);
      String code =
          result == null || result.get("code") == null ? "UNKNOWN" : result.get("code").asText();
      String message =
          result == null || result.get("message") == null
              ? "UNKNOWN"
              : result.get("message").asText();

      log.error(
          "토스 결제 취소 실패 HTTP 상태코드: {}, Payment Key: {}, 에러코드: {}, 에러메세지: {}",
          e.getStatusCode().value(),
          paymentKey,
          code,
          message);
      throw new RuntimeException("[%s]%s".formatted(code, message));
    } catch (Exception e) {
      log.error("토스 결제 취소 실패, Payment Key: {}, 메러메세지: {}", paymentKey, e.getMessage());
      throw new RuntimeException("[UNKNOWN]" + e.getMessage());
    }
  }
}
