package ar.com.notarip.bridge;

import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication(scanBasePackages={"ar.com.notarip.bridge"})
@RabbitListener(queues = "bridge.payment")
public class SpringBootRestApiApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApp.class, args);
    }
    
    @RabbitHandler
	public void process(@Payload String foo) {
		System.out.println(new Date() + ": " + foo);
}
}
