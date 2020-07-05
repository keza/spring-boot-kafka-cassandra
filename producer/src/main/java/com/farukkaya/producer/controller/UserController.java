package com.farukkaya.producer.controller;

import com.farukkaya.producer.model.dto.UserFollowerList;
import com.farukkaya.producer.model.dto.UserRegisterRequest;
import com.farukkaya.producer.model.dto.UserRegisterResponse;
import com.farukkaya.producer.model.entity.User;
import com.farukkaya.producer.service.KafkaService;
import com.farukkaya.producer.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRegisterResponse createUser(@RequestBody @Valid UserRegisterRequest request) {

        final User user = modelMapper.map(request, User.class);
        user.setCratedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC).getEpochSecond());
        user.setId(UUID.randomUUID());

        final UUID userId = userService.save(user).getId();

        final UserFollowerList followerList = modelMapper.map(user, UserFollowerList.class);

        kafkaService.sendUserData(followerList);

        return new UserRegisterResponse(userId);
    }
}
