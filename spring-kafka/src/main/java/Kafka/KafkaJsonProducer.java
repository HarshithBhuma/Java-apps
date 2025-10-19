package Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import Model.User;

@Service
public class KafkaJsonProducer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaJsonProducer.class);

	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendMessage(User userData) {

		Message<User> message = MessageBuilder.withPayload(userData).setHeader(KafkaHeaders.TOPIC, "jsonTopic").build();
		kafkaTemplate.send(message);

		logger.info("Json message sent to the topic: %s", userData.toString());
	}

}
