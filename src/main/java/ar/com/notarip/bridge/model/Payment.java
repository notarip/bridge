package ar.com.notarip.bridge.model;

import org.springframework.data.annotation.Id;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Payment {
	
	
	@Id
	private String id;
	
	private String status;
	
	private String description;
	
	private String email;
	
	private String gateway;
	
	private String currency;
	
	private Double mount;
	
	private String callbackUrl;

	
	public Payment() {
		// TODO Auto-generated constructor stub
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


	public String getGateway() {
		return gateway;
	}


	public void setGateway(String gateway) {
		this.gateway = gateway;
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
	
	@Override
	public String toString() {

		Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

		return gson.toJson(this);
	}
	
}
