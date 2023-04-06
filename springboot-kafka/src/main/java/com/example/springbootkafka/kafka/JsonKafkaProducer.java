package com.example.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.springbootkafka.Model.User;

@Service
public class JsonKafkaProducer {

private KafkaTemplate<String,User> kafkaTemplate;


private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaProducer.class);
public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
	super();
	this.kafkaTemplate = kafkaTemplate;
}


public void sendMessage(User data) {
	LOGGER.info(String.format("Message sent : %s",data.toString()));
	
	Message<User> message=MessageBuilder
		.withPayload(data)
		.setHeader(KafkaHeaders.TOPIC, "jsonTopic")
		.build();
		
			
	kafkaTemplate.send(message);
	
}

	
}
