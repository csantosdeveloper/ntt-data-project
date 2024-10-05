package com.ntt.data.project.domain.model.entities;

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
public class Payment {

    private String paymentId;

    private String user;

    private String pan;

    private BigDecimal amount;

    private String currency;

    private Date paymentDate = new Date();

    private String description;

}
