package ar.com.notarip.bridge.service;

import ar.com.notarip.bridge.service.dto.PaymentDTO;

public interface PaymentService {
	
	public PaymentDTO get(String id);

	public String save(PaymentDTO paymentDTO);

	public PaymentDTO getByExternalId(String id);

}
