package com.farukkaya.producer.service;

import com.farukkaya.producer.model.dto.UserFollowerList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUserData(UserFollowerList followerList) {

        try {
            String json = new ObjectMapper().writeValueAsString(followerList);
            kafkaTemplate.send("user_topic", followerList.getId().toString(), json);
            System.out.println("Message sent");
        } catch (JsonProcessingException e) {
            System.out.println("Error: when sending kafka message" + e.getMessage());
            e.printStackTrace();
        }

    }
}
