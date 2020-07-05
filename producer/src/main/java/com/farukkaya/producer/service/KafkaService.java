package com.farukkaya.producer.service;

import com.farukkaya.producer.model.dto.UserFollowerList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUserData(UserFollowerList followerList) {

        try {
            String json = new ObjectMapper().writeValueAsString(followerList);
            kafkaTemplate.send("user_topic", followerList.getId().toString(), json);
            logger.info("Message sent");
        } catch (JsonProcessingException e) {
            logger.error("Error: when sending kafka message" + e.getMessage());
        }

    }
}
