package ar.com.notarip.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.notarip.bridge.model.Payment;

@Service
public class PaymentProcessor {
	
	
	@Autowired
	GatewayService gatewayServiceMP;
	
	public PaymentProcessor() {
		// TODO Auto-generated constructor stub
	}
	
	
	public GatewayService getGateway(Payment payment){
		
		
		
		return gatewayServiceMP;
	}
	

}
