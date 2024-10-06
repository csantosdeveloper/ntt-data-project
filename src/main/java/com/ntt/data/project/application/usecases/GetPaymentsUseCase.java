package com.ntt.data.project.application.usecases;

import com.ntt.data.project.application.dto.PaymentResponse;

import java.util.List;

public interface GetPaymentsUseCase {

    List<PaymentResponse> execute(String userId);

}
