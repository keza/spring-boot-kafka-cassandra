package com.farukkaya.consumer.service;

import com.farukkaya.consumer.model.UserFollowers;
import com.farukkaya.consumer.repository.UserFollowersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaService {

    Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @Autowired
    private UserFollowersRepository repository;

    @KafkaListener(topics = "user_topic", groupId = "test1")
    public void listen(String message) throws JsonProcessingException {
        final UserFollowers userFollowers = new ObjectMapper().readValue(message, UserFollowers.class);
        userFollowers.setId(UUID.randomUUID());
        repository.save(userFollowers);

        logger.info("Received Messasge in group - group-id: " + message);
    }

}
