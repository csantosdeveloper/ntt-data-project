package com.ntt.data.project.application.services;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.usecases.GetPaymentsUseCase;
import com.ntt.data.project.application.usecases.RegisterPaymentUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.ntt.data.project.application.utils.TestDataUtil.getPaymentResponse;
import static com.ntt.data.project.application.utils.TestDataUtil.getRegisterPaymentRequest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {

    @InjectMocks
    private PaymentServiceImpl paymentService;

    @Mock
    private RegisterPaymentUseCase registerPaymentUseCase;

    @Mock
    private GetPaymentsUseCase getPaymentsUseCase;

    @Test
    void testRegisterPayment() {
        when(registerPaymentUseCase.execute(getRegisterPaymentRequest())).thenReturn(getPaymentResponse());

        PaymentResponse response = paymentService.registerPayment(getRegisterPaymentRequest());

        assertEquals("12345678A", response.getUserId());
    }

    @Test
    void testGetPayments() {
        String userId = "12345678A";

        when(getPaymentsUseCase.execute(userId)).thenReturn(List.of(getPaymentResponse()));

        List<PaymentResponse> responses = paymentService.getPaymentsByUserId(userId);

        assertEquals("12345678A", responses.get(0).getUserId());
    }

}
