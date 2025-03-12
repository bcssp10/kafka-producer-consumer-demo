package it.infocert.adapter.message.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class OrderKafkaListener {

    private static final Logger logger = LoggerFactory.getLogger(OrderKafkaListener.class);

    private static final String ORDER_TOPIC = "order-event";

    // Method to listen for messages from the specified Kafka topic
    @KafkaListener(topics = ORDER_TOPIC, containerFactory = "kafkaListenerContainerFactory")
    public void listen(OrderCreatedEvent message, Acknowledgment acknowledgment) {
        logger.info("Received order message: {}", message);
        acknowledgment.acknowledge();
    }
}