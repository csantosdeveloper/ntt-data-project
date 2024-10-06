package com.ntt.data.project.interfaces.rest;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.dto.RegisterPaymentRequest;
import com.ntt.data.project.domain.model.entities.Payment;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PaymentController implements PaymentApi {

    @Override
    public ResponseEntity<Payment> registerPayment(RegisterPaymentRequest request) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    public ResponseEntity<PaymentResponse> registerPayment(RegisterPaymentRequest request) {
    }

    @Override
    public ResponseEntity<List<Payment>> getPaymentsByUserId(String userId) {
        return null;
    public ResponseEntity<List<PaymentResponse>> getPaymentsByUserId(String userId) {
    }

}
