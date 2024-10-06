package com.ntt.data.project.domain.repository;

import com.ntt.data.project.domain.model.entities.Payment;
import com.ntt.data.project.domain.model.valueobjects.PaymentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, PaymentId> {
}
