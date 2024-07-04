package br.com.tallyto.kafka_sasl_without_ssl.controller;


import br.com.tallyto.kafka_sasl_without_ssl.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;

    @Autowired
    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public String sendMessageToKafkaTopic(@RequestBody String message) {
        producerService.sendMessage(message);
        return "Message sent to the Kafka Topic successfully: " + message;
    }
}
