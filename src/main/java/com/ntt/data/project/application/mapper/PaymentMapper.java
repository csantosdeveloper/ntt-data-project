package com.ntt.data.project.application.mapper;

import com.ntt.data.project.application.dto.PaymentResponse;
import com.ntt.data.project.application.utils.PanMasker;
import com.ntt.data.project.domain.model.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = PanMasker.class)
public interface PaymentMapper {

    @Mapping(target = "pan", expression = "java(PanMasker.mask(payment.getPan()))")
    PaymentResponse toResponse(Payment payment);

}
