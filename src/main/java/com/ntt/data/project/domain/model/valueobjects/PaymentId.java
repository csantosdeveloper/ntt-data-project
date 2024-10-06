package com.ntt.data.project.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class PaymentId implements Serializable {

    private String id;

    public PaymentId() {
        this.id = UUID.randomUUID().toString();
    }

}
