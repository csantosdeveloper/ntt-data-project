package com.ntt.data.project.application.mapper;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.domain.model.entities.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentResponse toResponse(Payment payment);

}
