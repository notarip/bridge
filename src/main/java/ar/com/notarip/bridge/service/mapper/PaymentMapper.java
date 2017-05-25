package ar.com.notarip.bridge.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import ar.com.notarip.bridge.model.Payment;
import ar.com.notarip.bridge.service.dto.PaymentDTO;


@Mapper(componentModel = "spring", uses = {})
public interface PaymentMapper {
	
	PaymentDTO toPaymentDTO(Payment payment);

    List<PaymentDTO> toPaymentDTOs(List<Payment> comments);

    Payment toPayment(PaymentDTO paymentDTO);

    List<Payment> toPayments(List<PaymentDTO> paymentDTOs);

}
