package ar.com.notarip.bridge.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.notarip.bridge.model.Payment;
import ar.com.notarip.bridge.model.SmartPayment;
import ar.com.notarip.bridge.repository.SmartPaymentRepository;

@Service
public class PaymentProcessor {

	@Autowired
	GatewayService gatewayServiceMP;

	@Autowired
	GatewayService gatewayServiceTP;

	@Autowired
	SmartPaymentRepository smartRepo;

	public PaymentProcessor() {
	}

	public GatewayService getGateway(Payment payment) {

		SmartPayment smart = smartRepo.findByName("criteria");
		SmartPayment criteria = smartRepo.findByName(smart.getCriteriaName());

		Date now = new Date();
		String gatewayName = "";

		switch (criteria.getName()) {
		case "date":
			gatewayName = getGatewayByDate(criteria, now);
			break;
		case "mount":
			gatewayName = getGatewayByMount(criteria, payment.getMount());
			break;

		}

		return getGateway(gatewayName);

	}

	private String getGatewayByMount(SmartPayment smart, Double mount) {

		String gatewayName;

		if (smart.getFromMount() <= mount && mount <= smart.getToMount()) {

			gatewayName = smart.getGatewayName();

		} else {

			gatewayName = smart.getGatewayAlternativeName();
		}

		return gatewayName;

	}

	private String getGatewayByDate(SmartPayment smart, Date now) {
		String gatewayName;
		if (smart.getFrom().before(now) && smart.getTo().after(now)) {

			gatewayName = smart.getGatewayName();

		} else {
			gatewayName = smart.getGatewayAlternativeName();
		}
		return gatewayName;
	}

	private GatewayService getGateway(String gatewayName) {

		switch (gatewayName) {
		case "TP":
			return gatewayServiceTP;
		case "MP":
			return gatewayServiceMP;
		default:
			return gatewayServiceMP;
		}

	}

}
