package ar.com.notarip.bridge.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class SmartPayment {
	
	@Id
	private String id;
	
	private String name;

	private String gatewayName;
	
	private String gatewayAlternativeName;
	
	private Date from;
	
	private Date to;
	
	private String criteriaName;
	
	private Double fromMount;
	
	private Double toMount;
	
	
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


	public Date getTo() {
		return to;
	}


	public void setTo(Date to) {
		this.to = to;
	}


	public Date getFrom() {
		return from;
	}


	public void setFrom(Date from) {
		this.from = from;
	}

	public String getGatewayAlternativeName() {
		return gatewayAlternativeName;
	}

	public void setGatewayAlternativeName(String gatewayAlternativeName) {
		this.gatewayAlternativeName = gatewayAlternativeName;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public Double getFromMount() {
		return fromMount;
	}

	public void setFromMount(Double fromMount) {
		this.fromMount = fromMount;
	}

	public Double getToMount() {
		return toMount;
	}

	public void setToMount(Double toMount) {
		this.toMount = toMount;
	}

}
