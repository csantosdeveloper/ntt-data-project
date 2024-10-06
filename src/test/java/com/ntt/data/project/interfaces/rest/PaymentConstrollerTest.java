package com.ntt.data.project.interfaces.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.dto.RegisterPaymentRequest;
import com.ntt.data.project.application.services.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

class PaymentControllerTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    void registerPayment_Success() throws Exception {
        // Arrange
        RegisterPaymentRequest request = new RegisterPaymentRequest();
        request.setUserId("12345678A");
        request.setPan("1234567812345678");
        request.setAmount(new BigDecimal("100.00"));
        request.setCurrency("USD");
        request.setDescription("Test payment");

        PaymentResponse paymentResponse = new PaymentResponse();

        when(paymentService.registerPayment(any(RegisterPaymentRequest.class))).thenReturn(paymentResponse);

        mockMvc.perform(post("/api/payments/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void registerPayment_BadRequest() throws Exception {
        RegisterPaymentRequest request = new RegisterPaymentRequest();

        mockMvc.perform(post("/api/payments/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getPaymentsByUserId_Success() throws Exception {
        String userId = "12345678A";
        List<PaymentResponse> paymentResponses = Collections.singletonList(new PaymentResponse());

        when(paymentService.getPaymentsByUserId(userId)).thenReturn(paymentResponses);

        // Act & Assert
        mockMvc.perform(get("/api/payments/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
