package ar.com.notarip.bridge;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationConfig {

	
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