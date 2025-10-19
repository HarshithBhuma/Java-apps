package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import Kafka.KafkaJsonProducer;
import Model.User;

@Controller
@RequestMapping("/api/kafka")
public class KafkaJsonController {
	
	@Autowired KafkaJsonProducer kafkaJsonProducer;
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User userData){
		kafkaJsonProducer.sendMessage(userData);
		return ResponseEntity.ok("json data send to the topic");
	}

}
