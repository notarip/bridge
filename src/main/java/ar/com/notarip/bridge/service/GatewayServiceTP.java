package ar.com.notarip.bridge.service;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.notarip.bridge.PaymentStatus;
import ar.com.notarip.bridge.ServiceTPConfig;
import ar.com.notarip.bridge.model.Payment;
import ar.com.notarip.bridge.model.PaymentTP;
import ar.com.notarip.bridge.repository.PaymentRepository;
import ar.com.notarip.bridge.repository.PaymentTPRepository;
import ar.com.notarip.bridge.util.TPHelper;
import ar.com.todopago.api.ElementNames;
import ar.com.todopago.api.TodoPagoConector;
import ar.com.todopago.api.exceptions.ConnectionException;
import ar.com.todopago.api.exceptions.EmptyFieldException;
import ar.com.todopago.api.exceptions.ResponseException;
import ar.com.todopago.api.model.User;

@Service(value = "gatewayServiceTP")
public class GatewayServiceTP implements GatewayService {

	
	private static final String GATEWAY_NAME = "TP";
	private static final String APPROVED = "APROBADA";
	
	@Autowired
	ServiceTPConfig serviceConfig;
	
	@Autowired
	TPHelper tpHelper;
	
	@Autowired
	IncrementalService incrementalService;
	
	@Autowired
	PaymentTPRepository paymentTPRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public String processPayment(Payment payment) {

		
		TodoPagoConector tpc = tpHelper.getConnector();

		Map<String, String> parameters = getParameters(payment);

		Map<String, Object> a = tpc.sendAuthorizeRequest(parameters, getFraudControlParameters());
		
		String checkOutUrl= (String) a.get("URL_Request");
		String requestKey = (String) a.get("RequestKey");
		//String publicRequestKey = (String) a.get("PublicRequestKey");
		
		
		PaymentTP paymentTP = new PaymentTP();
		paymentTP.setPaymentId(payment.getId());
		paymentTP.setPaymentTpId(parameters.get(ElementNames.OperationID));
		paymentTP.setRequestKey(requestKey);
		paymentTP.setStatus(PaymentStatus.INITIATED);
		
				
		paymentTPRepository.save(paymentTP);

		return checkOutUrl;
	}

	private Map<String, String> getParameters(Payment payment) {

		int  id= incrementalService.getNext(getGatewayName());
		String backUrl = serviceConfig.getBackUrl().replace("%id", String.valueOf(id));
		
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(ElementNames.Session, "ABCDEF-1234-12221-FDE1-00000200");
		parameters.put(ElementNames.Security, "1234567890ABCDEF1234567890ABCDEF");
		parameters.put(ElementNames.EncodingMethod, "XML");
		parameters.put(ElementNames.Merchant, serviceConfig.getMerchant()); // dato fijo (número identificador del comercio)
		parameters.put(ElementNames.OperationID, String.valueOf(id)); // número único que identifica la operación, generado por el comercio.
		parameters.put(ElementNames.CurrencyCode, "032"); // por el momento es el único tipo de moneda aceptada
		parameters.put(ElementNames.Amount, String.valueOf(payment.getMount()));
		parameters.put(ElementNames.UrlOK, backUrl);
		parameters.put(ElementNames.UrlError, backUrl);
		parameters.put(ElementNames.EMAILCLIENTE, payment.getEmail());
		
		
		return parameters;
	}

	public void getCredentials(TodoPagoConector tpc) {

		User user = new User("XXXX@gmail.com", "*******");// user y pass de TodoPago

		try {
			user = tpc.getCredentials(user);
			tpc.setAuthorize(getAuthorization(user));// set de la APIKey a TodoPagoConector

		} catch (EmptyFieldException e) {
			// logger.log(Level.WARNING, e.getMessage());
		} catch (MalformedURLException e) {
			// logger.log(Level.WARNING, e.getMessage());
		} catch (ResponseException e) {
			// logger.log(Level.WARNING, e.getMessage());
		} catch (ConnectionException e) {
			// logger.log(Level.WARNING, e.getMessage());
		}
		System.out.println(user.toString());
	}

	private Map<String, List<String>> getAuthorization(User user) {
		Map<String, List<String>> parameters = new HashMap<String, List<String>>();
		parameters.put(ElementNames.Authorization, Collections.singletonList(user.getApiKey()));

		return parameters;
	}


	private static Map<String, String> getFraudControlParameters() {

		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("CSBTCITY", "Villa General Belgrano"); // Ciudad de facturación, MANDATORIO.
		parameters.put("CSBTCOUNTRY", "AR");// País de facturación. MANDATORIO. Código ISO.
		parameters.put("CSBTCUSTOMERID", "453458"); // Identificador del usuario al que se le emite la factura. MANDATORIO. No puede contener un correo electrónico.
		parameters.put("CSBTIPADDRESS", "192.0.0.4"); // IP de la PC del comprador. MANDATORIO.
		parameters.put("CSBTEMAIL", "some@someurl.com"); // Mail del usuario al que se le emite la factura. MANDATORIO.
		parameters.put("CSBTFIRSTNAME", "Juan");// Nombre del usuario al que se le emite la factura. MANDATORIO.
		parameters.put("CSBTLASTNAME", "Perez");// Apellido del usuario al que se le emite la factura. MANDATORIO.
		parameters.put("CSBTPHONENUMBER", "541160913988");// Teléfono del usuario  MANDATORIO.
		parameters.put("CSBTPOSTALCODE", "1010");// Código Postal de la dirección de facturación. MANDATORIO.
		parameters.put("CSBTSTATE", "B");// Provincia de la dirección de facturación. MANDATORIO. Ver tabla anexa de provincias.
		parameters.put("CSBTSTREET1", "Some Street 2153");// Domicilio de facturación (calle y nro). MANDATORIO.
		parameters.put("CSBTSTREET2", "Piso 8");// Complemento del domicilio. (piso, departamento). NO MANDATORIO.
		parameters.put("CSPTCURRENCY", "ARS");// Moneda. MANDATORIO.
		parameters.put("CSPTGRANDTOTALAMOUNT", "125.38");// Con decimales opcional usando MANDATORIO.(Ejemplos:$125,38-> 125.38 $12-> 12 o 12.00)
		parameters.put("CSMDD7", "");// Fecha registro comprador(num Dias). NO MANDATORIO.
		parameters.put("CSMDD8", "Y"); // Usuario Guest? (Y/N). En caso de ser Y, el campo CSMDD9 no deberá enviarse. NO MANDATORIO.
		parameters.put("CSMDD9", "");// Customer password Hash: criptograma asociado al password del comprador final. NO MANDATORIO.
		parameters.put("CSMDD10", "");// Histórica de compras del comprador (Num transacciones). NO MANDATORIO.
		parameters.put("CSMDD11", "");// Customer Cell Phone. NO MANDATORIO. Retail
		parameters.put("CSSTCITY", "Villa General Belgrano");// Ciudad de enví­o de la orden. MANDATORIO.
		parameters.put("CSSTCOUNTRY", "AR");// País de envío de la orden. MANDATORIO.
		parameters.put("CSSTEMAIL", "some@someurl.com");// Mail del destinatario, MANDATORIO.
		parameters.put("CSSTFIRSTNAME", "Juan");// Nombre del destinatario. MANDATORIO.
		parameters.put("CSSTLASTNAME", "Perez");// Apellido del destinatario. MANDATORIO.
		parameters.put("CSSTPHONENUMBER", "541160913988");// Número de teléfono del destinatario. MANDATORIO.
		parameters.put("CSSTPOSTALCODE", "1010");// Código postal del domicilio de envío. MANDATORIO.
		parameters.put("CSSTSTATE", "B");// Provincia de envío. MANDATORIO. Son de 1 caracter
		parameters.put("CSSTSTREET1", "Some Street 2153");// Domicilio de envío MANDATORIO.
		parameters.put("CSSTSTREET2", "Piso 8");// Complemento del domicilio. (piso, departamento). NO MANDATORIO.
		parameters.put("CSMDD12", "");// Shipping DeadLine (Num Dias). NO MADATORIO.
		parameters.put("CSMDD13", "");// Método de Despacho. NO MANDATORIO.
		parameters.put("CSMDD14", "");// Customer requires Tax Bill ? (Y/N). NO MANDATORIO.
		parameters.put("CSMDD15", "");// Customer Loyality Number. NO MANDATORIO.
		parameters.put("CSMDD16", "");// Promotional / Coupon Code. NO MANDATORIO.

		// datos a enviar por cada producto, los valores deben estar separado
		// con #:
		parameters.put("CSITPRODUCTCODE", "electronic_good");// Código de producto. MANDATORIO. Valores posibles(adult_content;coupon;default;electronic_good;electronic_software;gift_certificate;handling_only;service;shipping_and_handling;shipping_only;subscription)
		parameters.put("CSITPRODUCTDESCRIPTION", "Test Prd Description");// Descripción del producto. MANDATORIO.
		parameters.put("CSITPRODUCTNAME", "TestPrd");// Nombre del producto.// CONDICIONAL.
		parameters.put("CSITPRODUCTSKU", "SKU1234");// Código identificador del													// producto. MANDATORIO.
		parameters.put("CSITTOTALAMOUNT", "10.01");// CSITTOTALAMOUNT=CSITUNITPRICE*CSITQUANTITY
		parameters.put("CSITQUANTITY", "1");// Cantidad del producto.					// CONDICIONAL.
		parameters.put("CSITUNITPRICE", "10.01");// Formato Idem							// CSITTOTALAMOUNT. CONDICIONAL.

		return parameters;
	}

	@Override
	public String getGatewayName() {
		return GATEWAY_NAME;
	}

	public String processAnswer(String id, String answer) {

		
		PaymentTP paymentTP = paymentTPRepository.findByPaymentTpId(id);
		Payment payment = paymentRepository.findById(paymentTP.getPaymentId());
		paymentTP.setAnswerKey(answer);
		
		Map<String, String> parameters = new HashMap<String, String>();		
		parameters.put(ElementNames.Security, "1234567890ABCDEF1234567890ABCDEF"); 
		parameters.put(ElementNames.Merchant, serviceConfig.getMerchant());
		parameters.put(ElementNames.RequestKey, paymentTP.getRequestKey());
		parameters.put(ElementNames.AnswerKey, answer); 
		
		TodoPagoConector tpc = tpHelper.getConnector();
		
		Map<String, Object> authorizeAnswer = tpc.getAuthorizeAnswer(parameters);
		
		String status = (String)authorizeAnswer.get("StatusMessage");
		
		if(status.equals(APPROVED)){
			paymentTP.setStatus(PaymentStatus.APPROVED);
			payment.setStatus(PaymentStatus.APPROVED);
		}
		
		paymentRepository.save(payment);
		paymentTPRepository.save(paymentTP);
		
		return payment.getCallbackUrl();
	}
}
