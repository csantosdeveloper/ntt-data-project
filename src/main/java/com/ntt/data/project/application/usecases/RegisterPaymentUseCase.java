package com.ntt.data.project.application.usecases;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.dto.RegisterPaymentRequest;

public interface RegisterPaymentUseCase {

    PaymentResponse execute(RegisterPaymentRequest request);

}
