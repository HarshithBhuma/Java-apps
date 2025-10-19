package Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import Model.User;

@Service
public class KafkaJsonConsumer {

	private static final Logger logger = LoggerFactory.getLogger(KafkaJsonConsumer.class);

	@KafkaListener(topics = "jsonTopic", groupId = "testGroup")
	public void consume(User userData) {
		logger.info("json message received: %s", userData.toString());
	}

}
