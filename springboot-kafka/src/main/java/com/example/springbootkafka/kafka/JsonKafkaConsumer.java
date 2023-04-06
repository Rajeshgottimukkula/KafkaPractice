package com.example.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.springbootkafka.Model.User;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaConsumer.class);
	@KafkaListener(topics = "jsonTopic",groupId = "myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Message received from topic is: %s",user.toString()));
		
	}
	
	
}
