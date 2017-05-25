package ar.com.notarip.bridge.service;

import ar.com.notarip.bridge.model.Payment;

public interface GatewayService {
	
	
	public String processPayment(Payment payment);
}
