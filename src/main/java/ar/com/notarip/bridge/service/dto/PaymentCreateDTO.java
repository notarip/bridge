package ar.com.notarip.bridge.service.dto;

public class PaymentCreateDTO {
	
	private String description;
	
	private String email;
	
	private String currency;
	
	private Double mount;
	
	private String callbackUrl;
	
	
	public PaymentCreateDTO() {
		// TODO Auto-generated constructor stub
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public Double getMount() {
		return mount;
	}


	public void setMount(Double mount) {
		this.mount = mount;
	}


	public String getCallbackUrl() {
		return callbackUrl;
	}


	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
	
	
	

}
