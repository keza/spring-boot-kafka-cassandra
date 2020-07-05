package com.farukkaya.producer.service;

import com.farukkaya.producer.model.entity.User;
import com.farukkaya.producer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User save (User user) {

        return repository.save(user);
    }
}
