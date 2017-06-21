package ar.com.notarip.bridge;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "common", ignoreUnknownFields = false)
public class CommonConfig {

	@Value("{events}")
	private String events;

	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}
		

	

}