package com.nordcloud.kafkademo.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/producer")
@RequiredArgsConstructor
@Slf4j
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void demoProducer() {

        for (int i = 0; i < 10000; i++) {
            StringBuilder message = new StringBuilder();
            message.append("Demo message #").append(i);
            produceMessage(message.toString(), "demo");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void demoProducerPost(@RequestBody String message) {

        produceMessage(message, "demo");
    }

    private void produceMessage(String message, String topic) {
        Message<String> stringMessage = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        log.info("Producer -> Message: {}", message);

        kafkaTemplate.send(stringMessage);
    }

}
