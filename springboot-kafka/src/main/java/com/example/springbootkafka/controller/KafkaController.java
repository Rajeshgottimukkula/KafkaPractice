package com.example.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootkafka.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

	@Autowired
	KafkaProducer kafkaProducer;

	public KafkaController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
	
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return new ResponseEntity<>("Message has been sent",HttpStatus.OK);
	}
	
	
	
}
