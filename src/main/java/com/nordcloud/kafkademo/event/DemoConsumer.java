package com.nordcloud.kafkademo.event;

import com.nordcloud.kafkademo.services.DemoService;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DemoConsumer {

    private final DemoService demoService;

    @KafkaListener(topics = "demo", containerFactory = "kafkaListenerContainerFactory")
    public void consumerListener(@Payload List<String> messageList) {
        //log.info("consumerListener started. Message: {}", messageList);

        for (List<String> partitionedMessageList : Lists.partition(messageList, 200)) {
            demoService.saveAll(partitionedMessageList);
        }

    }
}
