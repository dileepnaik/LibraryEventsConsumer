package com.learnkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;


//@Component
@Slf4j
public class LibraryEventsConsumerEventsManual implements AcknowledgingMessageListener<Integer,String> {

    @KafkaListener(topics = "library-events")
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {

        log.info("Consumer Record = {}", consumerRecord);

    }

    @Override
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord, Acknowledgment acknowledgment) {
        log.info("Consumer Record = {}", consumerRecord);
        acknowledgment.acknowledge();
    }
}
