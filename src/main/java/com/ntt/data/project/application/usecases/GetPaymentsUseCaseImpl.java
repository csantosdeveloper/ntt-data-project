package com.ntt.data.project.application.usecases;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.exceptions.DatabaseException;
import com.ntt.data.project.application.utils.PanMasker;
import com.ntt.data.project.domain.exceptions.InvalidUserException;
import com.ntt.data.project.application.mapper.PaymentMapper;
import com.ntt.data.project.domain.model.entities.Payment;
import com.ntt.data.project.domain.repository.PaymentRepository;
import com.ntt.data.project.domain.services.UserIdValidator;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Log4j2
@Service
public class GetPaymentsUseCaseImpl implements GetPaymentsUseCase {

    private final UserIdValidator userIdValidator;

    private final PaymentRepository paymentRepository;

    private final PaymentMapper paymentMapper;

    public List<PaymentResponse> execute(String userId) {
        try {
            userIdValidator.validate(userId);
            return getPaymentResponses(paymentRepository.findByUserId(userId));
        } catch (InvalidUserException e) {
            log.error("Invalid userId: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Error finding payments in database: {}", e.getMessage());
            throw new DatabaseException("Error finding payments in database");
        }
    }

    private List<PaymentResponse> getPaymentResponses(List<Payment> payments) {
        return payments.stream()
                .map(payment -> {
                    String maskedPan = PanMasker.mask(payment.getPan());
                    payment.setPan(maskedPan);
                    return paymentMapper.toResponse(payment);
                })
                .toList();
    }

}
