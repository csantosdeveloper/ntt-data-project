package com.ntt.data.project.application.usecases;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.exceptions.DatabaseException;
import com.ntt.data.project.application.mapper.PaymentMapper;
import com.ntt.data.project.domain.exceptions.InvalidUserException;
import com.ntt.data.project.domain.model.entities.Payment;
import com.ntt.data.project.domain.repository.PaymentRepository;
import com.ntt.data.project.domain.services.UserIdValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static com.ntt.data.project.application.utils.TestDataUtil.getPaymentResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPaymentsUseCaseImplTest {

    @InjectMocks
    private GetPaymentsUseCaseImpl getPaymentsUseCase;

    @Mock
    private UserIdValidator userIdValidator;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private PaymentMapper paymentMapper;

    @Test
    void testExecute() {
        String userId = "12345678A";

        when(paymentRepository.findByUserId(userId)).thenReturn(List.of(getPayment()));
        when(paymentMapper.toResponse(getPayment())).thenReturn(getPaymentResponse());

        List<PaymentResponse> responses = getPaymentsUseCase.execute(userId);

        assertEquals("1111222233334444", responses.get(0).getPan());
    }

    @Test
    void testExecuteInvalidUserException() {
        String userId = "123456BBA";

        doThrow(new InvalidUserException("User invalid")).when(userIdValidator).validate(userId);

        Exception responseError = assertThrows(RuntimeException.class, () -> getPaymentsUseCase.execute(userId));

        assertEquals("User invalid", responseError.getMessage());
    }

    @Test
    void testExecuteDatabaseException() {
        String userId = "12345678A";

        when(paymentRepository.findByUserId(userId)).thenThrow(RuntimeException.class);

        Exception responseError = assertThrows(DatabaseException.class, () -> getPaymentsUseCase.execute(userId));

        assertEquals("Error finding payments in database", responseError.getMessage());
    }

    private Payment getPayment() {
        return Payment.builder()
                .userId("12345678A")
                .pan("1111222233334444")
                .amount(BigDecimal.valueOf(12.00))
                .currency("EUR")
                .description("Test")
                .build();
    }

}
