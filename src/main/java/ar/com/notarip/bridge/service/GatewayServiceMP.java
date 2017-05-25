package ar.com.notarip.bridge.service;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadopago.MP;

import ar.com.notarip.bridge.ServiceConfig;
import ar.com.notarip.bridge.model.Payment;
import ar.com.notarip.bridge.repository.PaymentRepository;


@Service(value = "gatewayServiceMP")
public class GatewayServiceMP implements GatewayService {


	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	ServiceConfig serviceConfig;


	@Override
	public String processPayment(Payment payment) {

		String clientid = serviceConfig.getClientId();
		String clientsecret = serviceConfig.getClientSecret();
		
		paymentRepository.count();
		
		MP mp = new MP (clientid, clientsecret);
		String checkoutURL = null;
		
		JSONObject preference;
		try {
			preference = mp.createPreference("{'items':[{'title':'sdk-java','quantity':1,'currency_id':'ARS','unit_price':10.5}]}");
			checkoutURL = preference.getJSONObject("response").getString("init_point");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return checkoutURL;
	}


}
