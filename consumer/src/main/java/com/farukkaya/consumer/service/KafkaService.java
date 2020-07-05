package com.farukkaya.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @KafkaListener(topics = "user_topic", groupId = "test1")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }

}
