package ar.com.notarip.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.notarip.bridge.model.Payment;
import ar.com.notarip.bridge.repository.PaymentRepository;
import ar.com.notarip.bridge.service.dto.PaymentDTO;
import ar.com.notarip.bridge.service.mapper.PaymentMapper;



@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	PaymentMapper paymentMapper;
	
	@Autowired
	PaymentProcessor paymentProcessor;

	@Override
	public PaymentDTO get(String id) {

		Payment payment = paymentRepository.findById(id);
		
		PaymentDTO paymentDTO = paymentMapper.toPaymentDTO(payment);

		return paymentDTO;

	}

	@Override
	@Transactional
	public String save(PaymentDTO paymentDTO) {
		
		Payment payment = paymentMapper.toPayment(paymentDTO);
		
		GatewayService gateway = paymentProcessor.getGateway(payment);
		
		payment.setGateway(gateway.getGatewayName());

		payment = paymentRepository.save(payment);

		String url = gateway.processPayment(payment);
		
		return url;
	}
}
