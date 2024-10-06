package com.ntt.data.project.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponse {

    private String userId;

    private String pan;

    private BigDecimal amount;

    private String currency;

    private Date paymentDate;

    private String description;

}
