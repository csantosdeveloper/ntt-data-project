package com.ntt.data.project.domain.model.entities;

import com.ntt.data.project.domain.model.valueobjects.PaymentId;
import jakarta.persistence.*;
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
@Entity
@Table(name = "PAYMENTS")
public class Payment {

    @EmbeddedId
    @Column(name = "PAYMENT_ID")
    private PaymentId paymentId;

    @Column(name = "USER_ID", length = 9, nullable = false, unique = true)
    private String userId;

    @Column(name = "PAN", length = 16, nullable = false)
    private String pan;

    @Column(name = "AMOUNT", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "CURRENCY", length = 3, nullable = false)
    private String currency;

    @Column(name = "PAYMENT_DATE", nullable = false)
    private Date paymentDate;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    @PrePersist
    protected void onCreate() {
        paymentDate = new Date();
    }

}
