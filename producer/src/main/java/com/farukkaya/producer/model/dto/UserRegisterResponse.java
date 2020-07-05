package com.farukkaya.producer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserRegisterResponse {

    private UUID userId;
}
