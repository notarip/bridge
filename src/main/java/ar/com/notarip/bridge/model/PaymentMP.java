package ar.com.notarip.bridge.model;

import org.springframework.data.annotation.Id;

public class PaymentMP {
	
	@Id
	private String id;
	
	private String paymentId;
	
	private String status;
	
	private String preferenceId;
	


	
	public PaymentMP() {
		// TODO Auto-generated constructor stub
	}




	public String getPaymentId() {
		return paymentId;
	}




	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getPreferenceId() {
		return preferenceId;
	}




	public void setPreferenceId(String preferenceId) {
		this.preferenceId = preferenceId;
	}
	
}
