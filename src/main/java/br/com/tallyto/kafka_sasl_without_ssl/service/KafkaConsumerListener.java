package br.com.tallyto.kafka_sasl_without_ssl.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "your-topic-name", groupId = "my-consumer-group")
    public void listen(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
