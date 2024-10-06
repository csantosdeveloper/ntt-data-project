package com.ntt.data.project.application.services;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.dto.RegisterPaymentRequest;
import com.ntt.data.project.application.usecases.GetPaymentsUseCase;
import com.ntt.data.project.application.usecases.RegisterPaymentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final RegisterPaymentUseCase registerPaymentUseCase;

    private final GetPaymentsUseCase getPaymentsUseCase;

    @Override
    public PaymentResponse registerPayment(RegisterPaymentRequest request) {
        return registerPaymentUseCase.execute(request);
    }

    @Override
    public List<PaymentResponse> getPaymentsByUserId(String userId) {
        return getPaymentsUseCase.execute(userId);
    }

}
