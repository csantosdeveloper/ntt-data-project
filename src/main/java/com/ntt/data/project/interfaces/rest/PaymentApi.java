package com.ntt.data.project.interfaces.rest;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.dto.RegisterPaymentRequest;
import com.ntt.data.project.domain.model.entities.Payment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/payments")
public interface PaymentApi {

    @Operation(summary = "Register a new payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Payment created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Payment.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid payment request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @PostMapping("/register")
    ResponseEntity<Payment> registerPayment(@Valid @RequestBody RegisterPaymentRequest request);

    @Operation(summary = "Get a list of payments by user ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of payments",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Payment.class)))}),
            @ApiResponse(responseCode = "404", description = "Payments not found for the given user ID", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)
    })
    @GetMapping("/{userId}")
    ResponseEntity<List<Payment>> getPaymentsByUserId(@PathVariable String userId);

}
