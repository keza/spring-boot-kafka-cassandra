package com.farukkaya.producer.model.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserFollowerList {

    private UUID id;

    private List<Integer> followerList;
}
