package com.ntt.data.project.application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotNull(message = "userId must not be null")
    @Pattern(regexp = "^[0-9]{8}[A-Za-z]$", message = "userId must have correct format (8 digits plus 1 letter)")
    private String userId;

    @NotNull(message = "pan must not be null")
    @Pattern(regexp = "^\\d{16}$", message = "pan must have correct format (16 digits)")
    private String pan;

    @NotNull(message = "amount must not be null")
    private BigDecimal amount;

    @Pattern(regexp = "^[A-Za-z]{3}$", message = "currency must have correct format (3 letters)")
    private String currency;

    private String description;

}
