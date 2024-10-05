package com.ntt.data.project.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterPaymentRequest {

    private String user;

    private String pan;

    private BigDecimal amount;

    private String currency;

    private String description;

}
