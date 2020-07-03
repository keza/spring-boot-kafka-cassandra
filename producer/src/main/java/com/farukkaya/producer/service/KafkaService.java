package com.farukkaya.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUserData(String user) {
            kafkaTemplate.send("user_topic", "key", user);
            System.out.println("Message sent");

    }

    @KafkaListener(topics = "user_topic", groupId = "test1")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }
}
