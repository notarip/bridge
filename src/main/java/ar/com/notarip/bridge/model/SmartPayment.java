package ar.com.notarip.bridge.model;

import org.springframework.data.annotation.Id;

public class SmartPayment {
	
	@Id
	private String id;
	
	private String name;

	private String gatewayName;
	
	
	public SmartPayment() {
		
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public void setGatewayName(String gatewayName) {
		this.gatewayName = gatewayName;
	}
	

}
