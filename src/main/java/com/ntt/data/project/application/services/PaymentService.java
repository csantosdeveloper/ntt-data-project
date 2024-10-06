package com.ntt.data.project.application.services;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.dto.RegisterPaymentRequest;

import java.util.List;

public interface PaymentService {

    PaymentResponse registerPayment(RegisterPaymentRequest request);

    List<PaymentResponse> getPaymentsByUserId(String userId);

}
