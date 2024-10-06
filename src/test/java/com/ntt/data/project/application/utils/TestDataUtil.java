package com.ntt.data.project.application.utils;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.dto.RegisterPaymentRequest;

import java.math.BigDecimal;

public class TestDataUtil {

    public static RegisterPaymentRequest getRegisterPaymentRequest() {
        return RegisterPaymentRequest.builder()
                .userId("12345678A")
                .pan("1111222233334444")
                .amount(BigDecimal.valueOf(12.00))
                .currency("EUR")
                .description("Test")
                .build();
    }

    public static PaymentResponse getPaymentResponse() {
        return PaymentResponse.builder()
                .userId("12345678A")
                .pan("1111222233334444")
                .amount(BigDecimal.valueOf(12.00))
                .currency("EUR")
                .description("Test")
                .build();
    }

}
