package com.farukkaya.producer.controller;

import com.farukkaya.producer.model.User;
import com.farukkaya.producer.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody @Valid String user) {

        kafkaService.sendUserData(user);
        return user;
    }
}
