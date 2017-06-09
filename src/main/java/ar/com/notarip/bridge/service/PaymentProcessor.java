package ar.com.notarip.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.notarip.bridge.model.Payment;

@Service
public class PaymentProcessor {
	
	
	@Autowired
	GatewayService gatewayServiceMP;
	
	@Autowired
	GatewayService gatewayServiceTP;
	
	public PaymentProcessor() {
	}
	
	
	public GatewayService getGateway(Payment payment){
		
		if(payment.getMount() > 100)
				return gatewayServiceMP;
		else
			return gatewayServiceTP;
	}
	

}
