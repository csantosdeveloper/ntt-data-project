package com.ntt.data.project.application.usecases;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.exceptions.DatabaseException;
import com.ntt.data.project.application.mapper.PaymentMapper;
import com.ntt.data.project.domain.model.entities.Payment;
import com.ntt.data.project.domain.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.ntt.data.project.application.utils.TestDataUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterPaymentUseCaseImplTest {

    @InjectMocks
    private RegisterPaymentUseCaseImpl registerPaymentUseCase;

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private PaymentMapper paymentMapper;

    @Test
    void testExecute() {
        Payment payment = getPayment();

        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);
        when(paymentMapper.toResponse(payment)).thenReturn(getPaymentResponse());

        PaymentResponse responses = registerPaymentUseCase.execute(getRegisterPaymentRequest());

        assertEquals("1111********4444", responses.getPan());
    }

    @Test
    void testExecuteDatabaseException() {
        when(paymentRepository.save(any(Payment.class))).thenThrow(RuntimeException.class);

        Exception responseError = assertThrows(DatabaseException.class, () -> registerPaymentUseCase.execute(getRegisterPaymentRequest()));

        assertEquals("Error inserting payment request in database", responseError.getMessage());
    }

}
