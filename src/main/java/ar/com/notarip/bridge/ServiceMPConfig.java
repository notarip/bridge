package ar.com.notarip.bridge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "mercadopago", ignoreUnknownFields = false)
public class ServiceMPConfig {

	@Value("{client_id}")
	private String clientId;
	
	@Value("{client_secret}")
	private String clientSecret;

	@Value("{back_url}")
	private String backUrl;
	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	
	
//  @Override
//  public Mongo mongo() throws Exception {
//    return new MongoClient();
//  }
//
//  @Override
//  protected String getDatabaseName() {
//    return "wally";
//  }
}