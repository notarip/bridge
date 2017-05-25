package ar.com.notarip.bridge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// from https://springframework.guru/spring-boot-restful-api-documentation-with-swagger-2/
@Configuration
@EnableSwagger2
@ComponentScan("ar.com.notarip.bridge.controller")
public class SwaggerConf {

	   @Bean
	   public Docket customImplementation(){
	      return new Docket(DocumentationType.SWAGGER_2).select().build().apiInfo(metaData());

	   }
	   
	   private ApiInfo metaData() {
	        ApiInfo apiInfo = new ApiInfo(
	                "Spring Boot REST API",
	                "Spring Boot REST API for Social Network Wall",
	                "1.0",
	                "Terms of service",
	                new Contact("Pablo", "qb9", "pnotari@cmd.com.ar"),
	                null,
	                null);
	        return apiInfo;
	    }
	
}
