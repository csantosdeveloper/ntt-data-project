package com.ntt.data.project.interfaces.rest;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.dto.RegisterPaymentRequest;
import com.ntt.data.project.application.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PaymentController implements PaymentApi {

    private PaymentService paymentService;

    @Override
    public ResponseEntity<PaymentResponse> registerPayment(RegisterPaymentRequest request) {
        return new ResponseEntity<>(paymentService.registerPayment(request), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<PaymentResponse>> getPaymentsByUserId(String userId) {
        return new ResponseEntity<>(paymentService.getPaymentsByUserId(userId), HttpStatus.OK);
    }

}
