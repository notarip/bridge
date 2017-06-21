package ar.com.notarip.bridge.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ar.com.notarip.bridge.CommonConfig;

@Service
public class RabbitSender {

	public final static String QUEUE = "bridge.payment";
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private CommonConfig commonConfig;
	
	@Scheduled(fixedDelay = 1000L)
	public void send(String topic, String event) {
		
		if(commonConfig.getEvents().equals("true"))
			this.rabbitTemplate.convertAndSend(topic, event);
	}
	
	
}
