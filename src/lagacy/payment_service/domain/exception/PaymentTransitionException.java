package lagacy.payment_service.domain.exception;

import lagacy.payment_service.domain.PaymentStatus;
import org.apache.coyote.BadRequestException;

public class PaymentTransitionException extends BadRequestException {

    public PaymentTransitionException(PaymentStatus currantStatus, PaymentStatus newStatus) {
        super("유효하지 않은 결제 상태 변경입니다 - 현재상태: $s, 변경될 상태: %s".formatted(currantStatus, newStatus));


    }

}
