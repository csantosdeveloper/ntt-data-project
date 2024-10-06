package com.ntt.data.project.application.usecases;

import com.ntt.data.project.application.constants.Constants;
import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.dto.RegisterPaymentRequest;
import com.ntt.data.project.application.exceptions.DatabaseException;
import com.ntt.data.project.application.mapper.PaymentMapper;
import com.ntt.data.project.domain.model.entities.Payment;
import com.ntt.data.project.domain.model.valueobjects.PaymentId;
import com.ntt.data.project.domain.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Log4j2
@Service
public class RegisterPaymentUseCaseImpl implements RegisterPaymentUseCase {

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    public PaymentResponse execute(RegisterPaymentRequest request) {
        try {
            Payment payment = paymentRepository.save(getPaymentEntity(request));
            return paymentMapper.toResponse(payment);
        } catch (Exception e) {
            log.error("Error inserting payment request in database: {}", e.getMessage());
            throw new DatabaseException("Error inserting payment request in database");
        }
    }

    private Payment getPaymentEntity(RegisterPaymentRequest request) {
        return Payment.builder()
                .paymentId(new PaymentId())
                .userId(request.getUserId())
                .pan(request.getPan())
                .amount(request.getAmount())
                .currency(Optional.ofNullable(request.getCurrency()).orElse(Constants.DEFAULT_CURRENCY))
                .description(Optional.ofNullable(request.getDescription()).orElse(Constants.NO_DESCRIPTION))
                .build();
    }

}
