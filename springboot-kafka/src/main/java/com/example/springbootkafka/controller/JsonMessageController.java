package com.example.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootkafka.Model.User;
import com.example.springbootkafka.kafka.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	
    @Autowired
	JsonKafkaProducer kafkaProducer;

	public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
    
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User data){
    	
    	kafkaProducer.sendMessage(data);
    	return new ResponseEntity<>("Json message sent to kafka topic",HttpStatus.OK);
    }
   
	
	
}
