package ar.com.notarip.bridge.model;

import org.springframework.data.annotation.Id;

public class PaymentTP {
	
	
	@Id
	private String id;
	
	private String paymentTpId;
	
	private String paymentId;
	
	private String requestKey;
	
	private String answerKey;
	
	private String status;
	
	
	public PaymentTP() {
		
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getRequestKey() {
		return requestKey;
	}

	public void setRequestKey(String requestKey) {
		this.requestKey = requestKey;
	}

	public String getAnswerKey() {
		return answerKey;
	}

	public void setAnswerKey(String answerKey) {
		this.answerKey = answerKey;
	}

	public String getPaymentTpId() {
		return paymentTpId;
	}

	public void setPaymentTpId(String paymentTpId) {
		this.paymentTpId = paymentTpId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
