package com.farukkaya.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @KafkaListener(topics = "user_topic", groupId = "test1")
    public void listen(String message) {
        logger.info("Received Messasge in group - group-id: " + message);
    }

}
