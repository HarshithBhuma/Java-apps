package demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.publisher.RabbitMQProducer;

@RestController
@RequestMapping("/api/test")
public class RabbitMQController {

	private RabbitMQProducer producer;

	public RabbitMQController(RabbitMQProducer producer) {
		this.producer = producer;
	}

	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
		producer.sendMessage(message);
		return ResponseEntity.ok("message sent to RabbitMQ..");
	}

}
